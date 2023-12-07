package ru.astondevs.lab.account.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Account {
    @Id
    @Column("name")
    private String name;

    @Column("number")
    private Integer number;

    @Column("account")
    private Integer account;

    @Column("version")
    private Long version;
}
