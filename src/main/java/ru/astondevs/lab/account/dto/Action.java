package ru.astondevs.lab.account.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Action {
    private String action;
    private String name;
    private Integer pin;
    private Integer fromAccount;
    private Integer toAccount;
    private Integer amount;
}
