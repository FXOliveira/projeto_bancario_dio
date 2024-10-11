package com.felipe.project.bank.controller;

import com.felipe.project.bank.exceptions.ErroOperacaoBancariaException;
import com.felipe.project.bank.model.Conta;
import com.felipe.project.bank.model.ContaCorrente;
import com.felipe.project.bank.service.ContaCorrenteService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class ContaCorrenteServiceTest {

    @Mock
    private ContaCorrenteService contaCorrenteService;
    private ContaCorrente contaCorrente;
    @BeforeEach
    void setUp() {
        contaCorrente = new ContaCorrente();
        contaCorrente.setId(1L);
        contaCorrente.setSaldo(10000.0);
        contaCorrente.setTitular("fulano");
        contaCorrente.setAgencia("agencia x");
    }
    @Test
    void deposit_WhenInvalidValue_ThenThrowException() throws ErroOperacaoBancariaException {
        Mockito.doThrow(new ErroOperacaoBancariaException("Valor de depósito inválido"))
                .when(contaCorrenteService).depositar(1L, -100.0);

        assertThrows(ErroOperacaoBancariaException.class, () ->
                contaCorrenteService.depositar(1L, -100.0));

        Mockito.verify(contaCorrenteService).depositar(1L, -100.0);

    }
    @Test
    void saque_WhenInvalidValue_ThenThrowException() throws ErroOperacaoBancariaException {

        Mockito.doThrow(new ErroOperacaoBancariaException("Valor de saque inválido!!"))
                .when(contaCorrenteService).sacar(1L, -100.0);

        Mockito.doThrow(new ErroOperacaoBancariaException("Valor de saque inválido!!"))
                .when(contaCorrenteService).sacar(1L, 11000.0);

    }


}