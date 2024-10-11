package com.felipe.project.bank.service;

import com.felipe.project.bank.exceptions.ErroOperacaoBancariaException;
import com.felipe.project.bank.interfaces.GenericCrudInterface;
import com.felipe.project.bank.interfaces.OperacoesBancariasInterface;
import com.felipe.project.bank.model.ContaCorrente;
import com.felipe.project.bank.repository.ContaCorrenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class ContaCorrenteService implements GenericCrudInterface<ContaCorrente>,
        OperacoesBancariasInterface<ContaCorrente> {
    @Autowired
    private ContaCorrenteRepository contaCorrenteRepository;
    @Override
    public void save(ContaCorrente conta) {
        contaCorrenteRepository.save(conta);
    }
    @Override
    public ContaCorrente findById(Long id) {
        return contaCorrenteRepository.findById(id).get();
    }

    @Override
    public List<ContaCorrente> findAll() {
        List<ContaCorrente> contas = new ArrayList<>();
        contaCorrenteRepository.findAll().forEach(cc -> contas.add(cc));
        return contas;
    }
    @Override
    public void delete(Long id) {
        contaCorrenteRepository.deleteById(id);
    }
    @Override
    public ResponseEntity<Void> depositar(Long id, double valor) throws ErroOperacaoBancariaException {
        ContaCorrente contaCorrente = contaCorrenteRepository.findById(id).orElseThrow(() ->
                new ErroOperacaoBancariaException("Conta não encontrada!!"));

        if(valor <= 0){
            throw new ErroOperacaoBancariaException("Valor de depósito inválido!!");
        }

        double novoValor = contaCorrente.getSaldo() + valor;

        contaCorrente.setSaldo(novoValor);

        contaCorrenteRepository.save(contaCorrente);

        return ResponseEntity.noContent().build();

    }
    
    @Override
    public ResponseEntity<Void> sacar(Long id, double valor) throws ErroOperacaoBancariaException {
        ContaCorrente contaCorrente = contaCorrenteRepository.findById(id).orElseThrow(() ->
                new ErroOperacaoBancariaException("Conta não encontrada!!"));

        if(valor > contaCorrente.getSaldo() || valor <= 0){
            throw new ErroOperacaoBancariaException("Valor de saque inválido!!");
        }

        double novoValor = contaCorrente.getSaldo() - valor;

        contaCorrente.setSaldo(novoValor);

        contaCorrenteRepository.save(contaCorrente);

        return ResponseEntity.noContent().build();

    }

}


