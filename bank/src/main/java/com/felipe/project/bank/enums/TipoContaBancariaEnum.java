package com.felipe.project.bank.enums;

public enum TipoContaBancariaEnum {

    CONTA_CORRENTE("CORRENTE"),
    CONTA_POUPANCA("POUPANCA");

    private final String valor;
    
    TipoContaBancariaEnum(String valor){
        this.valor = valor;
    }
    public String getValor() {
        return valor;
    }
}
