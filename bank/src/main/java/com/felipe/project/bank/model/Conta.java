package com.felipe.project.bank.model;

import com.felipe.project.bank.enums.TipoContaEnum;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "conta_bancaria")
public class Conta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "agencia")
    private String agencia;
    @Column(name = "titular")
    private String titular;
    @Column(name = "tipo_conta")
    private TipoContaEnum tipoContaEnum;
    @Column(name = "saldo")
    private double saldo;

    public Conta(String agencia, String titular, TipoContaEnum tipoContaEnum) {
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

    public TipoContaEnum getTipoContaEnum() {
        return tipoContaEnum;
    }

    public void setTipoContaEnum(TipoContaEnum tipoContaEnum) {
        this.tipoContaEnum = tipoContaEnum;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}
