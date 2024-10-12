package com.felipe.project.bank.interfaces;

import com.felipe.project.bank.exceptions.ErroOperacaoBancariaException;
import org.springframework.http.ResponseEntity;

public interface OperacoesBancariasInterface<T> {

    public ResponseEntity<Void> depositar(Long id, double valor) throws ErroOperacaoBancariaException;
    public ResponseEntity<Void> sacar(Long id, double valor) throws ErroOperacaoBancariaException

}
