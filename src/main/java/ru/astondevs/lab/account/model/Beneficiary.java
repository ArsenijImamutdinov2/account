package ru.astondevs.lab.account.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table("beneficiary")
public class Beneficiary {
    @Id
    @Column("NAME")
    private String name;
    @Column("PIN")
    private int pin;
    @Version
    @Column("VERSION")
    private Long version;
}
