package com.felipe.project.bank.service;

import com.felipe.project.bank.exceptions.ErroOperacaoBancariaException;
import com.felipe.project.bank.interfaces.GenericCrudInterface;
import com.felipe.project.bank.model.Conta;
import com.felipe.project.bank.repository.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class ContaBancariaService implements GenericCrudInterface<Conta> {
    @Autowired
    private ContaRepository contaRepository;
    @Override
    public void save(Conta conta) {
        contaRepository.save(conta);
    }
    @Override
    public Conta findById(Long id) {
        return contaRepository.findById(id).get();
    }

    @Override
    public List<Conta> findAll() {
        List<Conta> contas = new ArrayList<>();
        contaRepository.findAll().forEach(cc -> contas.add(cc));
        return contas;
    }
    @Override
    public void delete(Long id) {
        contaRepository.deleteById(id);
    }

    public void depositar(Long id, double valor) throws ErroOperacaoBancariaException {
        contaRepository.findById(id).orElseThrow(() ->
                new ErroOperacaoBancariaException("Conta não encontrada!!"));
        if(valor <= 0){
            throw new ErroOperacaoBancariaException("Valor inválido a ser depositado!!");
        }
        Conta conta = contaRepository.findById(id).get();
        double valorAtualizado = conta.getSaldo() + valor;

        conta.setSaldo(valorAtualizado);

        contaRepository.save(conta);

    }

}


