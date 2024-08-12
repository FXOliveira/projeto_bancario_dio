package com.felipe.project.bank.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

@MappedSuperclass
public abstract class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "agencia")
    private String agencia;
    @Column(name = "titular")
    private String titular;
    @Column(name = "saldo")
    private BigDecimal saldo;

    public Conta(String agencia, String titular) {
        this.agencia = agencia;
        this.titular = titular;
        this.saldo = BigDecimal.ZERO;
    }

    public Conta(){
        this.saldo = BigDecimal.ZERO;
    }

    public Long getId() {
        return id;
    }
    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }
    public String getTitular() {
        return titular;
    }
    public void setTitular(String titular) {
        this.titular = titular;
    }
}
