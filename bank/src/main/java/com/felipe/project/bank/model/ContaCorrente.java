package com.felipe.project.bank.model;

import com.felipe.project.bank.enums.TipoContaBancariaEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "conta_corrente")
public class ContaCorrente extends Conta {
    public ContaCorrente(String agencia, String titular, TipoContaBancariaEnum tipoContaEnum) {
        super(agencia, titular, tipoContaEnum);
    }
    public ContaCorrente() {
    }

}
