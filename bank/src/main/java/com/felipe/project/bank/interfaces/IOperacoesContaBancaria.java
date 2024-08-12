package com.felipe.project.bank.interfaces;

import java.math.BigDecimal;

public interface IOperacoesContaBancaria {
    public void depositar(BigDecimal valor);
    public void sacar(BigDecimal valor);
    public void transferir(BigDecimal valor);
}
