package ru.pshiblo.personal.domain;

import lombok.Data;
import ru.pshiblo.personal.enums.AccountType;
import ru.pshiblo.personal.enums.Currency;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Data
@Table(name = "accounts")
@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "number", nullable = false)
    private Integer number;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false, length = 50)
    private AccountType type;

    @Column(name = "balance", nullable = false, precision = 131089)
    private BigDecimal balance;

    @Column(name = "lock", nullable = false)
    private Boolean lock = false;

    @Enumerated(EnumType.STRING)
    @Column(name = "currency", nullable = false, length = 3)
    private Currency currency;
}