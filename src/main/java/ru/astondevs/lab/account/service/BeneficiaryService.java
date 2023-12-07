package ru.astondevs.lab.account.service;

import lombok.AllArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import ru.astondevs.lab.account.model.Beneficiary;
import ru.astondevs.lab.account.repository.BeneficiaryRepository;

@Service
@AllArgsConstructor
@Setter
public class BeneficiaryService {

    @Autowired
    private BeneficiaryRepository beneficiaryRepository;

    public Flux<Beneficiary> all() {
        return beneficiaryRepository.findAll();
    }
}
