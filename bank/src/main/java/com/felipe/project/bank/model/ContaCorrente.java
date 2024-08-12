package com.felipe.project.bank.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "conta_corrente")
public class ContaCorrente extends Conta {
    public ContaCorrente(String agencia, String titular) {
        super(agencia, titular);
    }
}
