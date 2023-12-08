package ru.astondevs.lab.account.service;

import lombok.AllArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.astondevs.lab.account.dto.Action;
import ru.astondevs.lab.account.model.Account;
import ru.astondevs.lab.account.model.Log;
import ru.astondevs.lab.account.repository.AccountRepository;
import ru.astondevs.lab.account.repository.BeneficiaryRepository;
import ru.astondevs.lab.account.repository.LogRepository;

@Service
@AllArgsConstructor
@Setter
public class AccountService {
    private AccountRepository accountRepository;
    private BeneficiaryRepository beneficiaryRepository;
    private LogRepository logRepository;

    public Flux<Account> getByBeneficiary(String name, int pin) {
       return beneficiaryRepository.findById(name).flatMapMany(beneficiary -> {
           if (beneficiary.getPin() == pin)
               return accountRepository.findByName(beneficiary.getName());
            else
               return Flux.empty();
        });
    }
    @Transactional
    public Mono<Boolean> doAction(Action action) {
        return beneficiaryRepository.findById(action.getName()).flatMap(beneficiary -> {
            if (beneficiary.getPin() == action.getPin()) {
                switch (action.getAction().toUpperCase()) {
                    case "DEPOSIT":
                        accountRepository.findByNameAndNumber(beneficiary.getName(), action.getToAccount()).map(toAccount -> {
                            toAccount.setAmount(toAccount.getAmount() + action.getAmount());
                            return accountRepository.save(toAccount)
                                    .map(t -> logRepository.save(new Log(null, null, toAccount.getNumber(), action.getAmount(), "DEPOSIT", null)))
                                    .map(t1 -> Mono.just(Boolean.TRUE));
                        });
                    case "TRANSFER":
                        accountRepository.findByNameAndNumber(beneficiary.getName(), action.getFromAccount()).map(fromAccount -> {
                            if (fromAccount.getAmount() >= action.getAmount()) {
                                return accountRepository.findByNameAndNumber(beneficiary.getName(), action.getFromAccount())
                                        .map(toAccount -> {
                                            fromAccount.setAmount(fromAccount.getAmount() - action.getAmount());
                                            toAccount.setAmount(toAccount.getAmount() + action.getAmount());
                                            return accountRepository.save(fromAccount)
                                                    .map(t2 -> accountRepository.save(toAccount))
                                                    .map(t3 -> logRepository.save(new Log(null, fromAccount.getNumber(), toAccount.getNumber(), action.getAmount(), "TRANSFER", null)))
                                                    .map(t4 -> Mono.just(Boolean.TRUE));
                                        });


                            } else
                                return Mono.just(Boolean.FALSE);
                        });
                    case "WITHDRAW":
                        accountRepository.findByNameAndNumber(beneficiary.getName(), action.getFromAccount()).map(fromAccount -> {
                            if (fromAccount.getAmount() >= action.getAmount()) {
                                fromAccount.setAmount(fromAccount.getAmount() - action.getAmount());
                                return accountRepository.save(fromAccount)
                                        .map(t -> logRepository.save(new Log(null, fromAccount.getNumber(), null, action.getAmount(), "WITHDRAW", null)))
                                        .map(t1 -> Mono.just(Boolean.TRUE));
                            } else
                                return Mono.just(Boolean.FALSE);
                        });
                    default:
                        return Mono.just(Boolean.FALSE);
                }
            } else
                return Mono.just(Boolean.FALSE);
        });
    }
}
