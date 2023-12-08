package ru.astondevs.lab.account.controller;

import lombok.AllArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import ru.astondevs.lab.account.model.Log;
import ru.astondevs.lab.account.service.LogService;

@RestController
@AllArgsConstructor
@Setter
@RequestMapping("/log")
public class LogController {
    private LogService logService;

    @GetMapping
    public Flux<Log> getAccounts(@RequestParam("name") String beneficiaryName, @RequestHeader("pin") Integer beneficiaryPin) {
        return logService.getByBeneficiary(beneficiaryName, beneficiaryPin);
    }
}
