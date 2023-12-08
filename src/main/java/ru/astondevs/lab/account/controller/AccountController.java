package ru.astondevs.lab.account.controller;

import lombok.AllArgsConstructor;
import lombok.Setter;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.astondevs.lab.account.dto.Action;
import ru.astondevs.lab.account.model.Account;
import ru.astondevs.lab.account.service.AccountService;

@RestController
@AllArgsConstructor
@Setter
@RequestMapping("/accounts")
public class AccountController {
    private AccountService accountService;

    @GetMapping
    public Flux<Account> getAccounts(@RequestParam("name") String beneficiaryName, @RequestHeader("pin") Integer beneficiaryPin) {
        return accountService.getByBeneficiary(beneficiaryName, beneficiaryPin);
    }

    @PostMapping
    public Mono<Boolean> doAction(@RequestBody Action action) {
        return accountService.doAction(action);
    }
}
