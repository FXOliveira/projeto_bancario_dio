package com.felipe.project.bank.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "conta_poupanca")
public class ContaPoupanca extends Conta {
    public ContaPoupanca(String agencia, String titular) {
        super(agencia, titular);
    }
}
