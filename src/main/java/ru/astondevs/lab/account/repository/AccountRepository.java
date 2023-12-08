package ru.astondevs.lab.account.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.astondevs.lab.account.model.Account;

public interface AccountRepository extends ReactiveCrudRepository<Account, Integer> {
    Flux<Account> findByName(String name);
    Mono<Account> findByNameAndNumber(String Name, Integer number);
}
