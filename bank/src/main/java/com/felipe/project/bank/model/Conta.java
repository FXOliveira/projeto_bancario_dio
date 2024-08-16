package com.felipe.project.bank.model;

import com.felipe.project.bank.enums.TipoContaBancariaEnum;
import jakarta.persistence.*;

@MappedSuperclass
public abstract class Conta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "agencia")
    private String agencia;
    @Column(name = "titular")
    private String titular;
    @Column(name = "tipo_conta")
    private TipoContaBancariaEnum tipoContaEnum;
    @Column(name = "saldo")
    private double saldo;

    public Conta(String agencia, String titular, TipoContaBancariaEnum tipoContaEnum) {
        this.agencia = agencia;
        this.titular = titular;
        this.tipoContaEnum = tipoContaEnum;
        this.saldo = 0;
    }

    public Conta() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public TipoContaBancariaEnum getTipoContaEnum() {
        return tipoContaEnum;
    }

    public void setTipoContaEnum(TipoContaBancariaEnum tipoContaEnum) {
        this.tipoContaEnum = tipoContaEnum;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}
