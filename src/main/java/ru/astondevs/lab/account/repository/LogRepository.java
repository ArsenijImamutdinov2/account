package ru.astondevs.lab.account.repository;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import ru.astondevs.lab.account.model.Log;

public interface LogRepository extends ReactiveCrudRepository<Log, Long> {
    @Query("select * from log where FROM_ACCOUNT in (select \"NUMBER\" from account where \"NAME\" = :name) or TO_ACCONT in (select \"NUMBER\" from account where \"NAME\" = :name)")
    Flux<Log> findByBeneficiaryName(String name);
}
