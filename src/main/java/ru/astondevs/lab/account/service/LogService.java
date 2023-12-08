package ru.astondevs.lab.account.service;

import lombok.AllArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import ru.astondevs.lab.account.model.Log;
import ru.astondevs.lab.account.repository.BeneficiaryRepository;
import ru.astondevs.lab.account.repository.LogRepository;

@Service
@AllArgsConstructor
@Setter
public class LogService {
    private BeneficiaryRepository beneficiaryRepository;
    private LogRepository logRepository;

    public Flux<Log> getByBeneficiary(String name, int pin) {
        return beneficiaryRepository.findById(name).flatMapMany(beneficiary -> {
            if (beneficiary.getPin() == pin)
                return logRepository.findByBeneficiaryName(beneficiary.getName());
            else
                return Flux.empty();
        });
    }
}
