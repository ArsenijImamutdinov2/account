package ru.astondevs.lab.account.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table("account")
public class Account {
    @Column("NAME")
    private String name;

    @Id
    @Column("NUMBER")
    private Integer number;

    @Column("AMOUNT")
    private Integer amount;

    @Column("VERSION")
    private Long version;
}
