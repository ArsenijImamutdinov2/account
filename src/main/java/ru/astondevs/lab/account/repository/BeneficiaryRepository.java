package ru.astondevs.lab.account.repository;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import ru.astondevs.lab.account.model.Beneficiary;

public interface BeneficiaryRepository  extends ReactiveCrudRepository<Beneficiary, String> {

    @Query("SELECT * FROM beneficiary where NAME = :name")
    Flux<Beneficiary> findByName(String name);
}
