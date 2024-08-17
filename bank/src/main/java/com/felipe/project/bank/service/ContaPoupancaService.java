package com.felipe.project.bank.service;

import com.felipe.project.bank.interfaces.GenericCrudInterface;
import com.felipe.project.bank.model.ContaPoupanca;
import com.felipe.project.bank.repository.ContaPoupancaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class ContaPoupancaService implements GenericCrudInterface<ContaPoupanca> {
    @Autowired
    private ContaPoupancaRepository contaPoupancaRepository;

    @Override
    public void save(ContaPoupanca conta) {
        contaPoupancaRepository.save(conta);
    }

    @Override
    public ContaPoupanca findById(Long id) {
        return contaPoupancaRepository.findById(id).get();
    }

    @Override
    public List<ContaPoupanca> findAll() {
        List<ContaPoupanca> contas = new ArrayList<>();
        contaPoupancaRepository.findAll().forEach(cc -> contas.add(cc));
        return contas;
    }
    @Override
    public void delete(Long id) {
        contaPoupancaRepository.deleteById(id);
    }

    // MÉTODOS A SEREM AINDA IMPLEMENTADOS
    public ResponseEntity<String> depositar()
    {
        return ResponseEntity.ok("DEPOSITO CONTA POUPANÇA");
    }

    public ResponseEntity<String> sacar(){
        return ResponseEntity.ok("SAQUE CONTA POUPANÇA");
    }
    public ResponseEntity<String> transferir(){
        return ResponseEntity.ok("TRANSFERÊNCIA CONTA POUPANÇA");
    }

    }


