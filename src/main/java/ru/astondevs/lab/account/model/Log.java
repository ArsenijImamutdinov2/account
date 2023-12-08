package ru.astondevs.lab.account.model;

import lombok.*;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table("log")
public class Log {
    @Column("ID")
    private Long id;

    @Column("FROM_ACCOUNT")
    private Integer fromAccount;

    @Column("TO_ACCONT")
    private Integer toAccount;

    @Column("AMOUNT")
    private Integer amount;

    @Column("ACTION")
    private String action;

    @Column("VERSION")
    private Long version;
}
