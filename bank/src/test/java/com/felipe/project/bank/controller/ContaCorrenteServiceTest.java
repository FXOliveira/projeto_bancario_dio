package com.felipe.project.bank.controller;

import com.felipe.project.bank.exceptions.ErroOperacaoBancariaException;
import com.felipe.project.bank.model.ContaCorrente;
import com.felipe.project.bank.service.ContaCorrenteService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ContaCorrenteServiceTest {

    @Mock
    private ContaCorrenteService contaCorrenteService;
    private ContaCorrente contaCorrente;
    @BeforeEach
    void setUp() {
        contaCorrente = new ContaCorrente();
        contaCorrente.setId(1L);
        contaCorrente.setTitular("fulano");
        contaCorrente.setAgencia("agencia x");
    }
    @Test
    void deposit_WhenInvalidValue_ThenThrowException() throws ErroOperacaoBancariaException {
        Mockito.doThrow(new ErroOperacaoBancariaException("Valor de depósito inválido"))
                .when(contaCorrenteService).depositar(1L, -100.0);

        Assertions.assertThrows(ErroOperacaoBancariaException.class, () ->
                contaCorrenteService.depositar(1L, -100.0));

        Mockito.verify(contaCorrenteService).depositar(1L, -100.0);

    }

}