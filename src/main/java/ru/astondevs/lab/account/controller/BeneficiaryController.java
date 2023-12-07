package ru.astondevs.lab.account.controller;

import lombok.AllArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import ru.astondevs.lab.account.model.Beneficiary;
import ru.astondevs.lab.account.service.BeneficiaryService;

@RestController
@AllArgsConstructor
@Setter
@RequestMapping("/beneficiaries")
public class BeneficiaryController {
    @Autowired
    private BeneficiaryService beneficiaryService;

    @GetMapping
    public Flux<Beneficiary> getAll() {
        return beneficiaryService.all();
    }
}
