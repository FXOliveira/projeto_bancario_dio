package com.felipe.project.bank.model;

import com.felipe.project.bank.enums.TipoContaBancariaEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "conta_poupanca")
public class ContaPoupanca extends Conta {
    public ContaPoupanca(String agencia, String titular, TipoContaBancariaEnum tipoContaEnum) {
        super(agencia, titular, tipoContaEnum);
    }
    public ContaPoupanca() {
    }
}
