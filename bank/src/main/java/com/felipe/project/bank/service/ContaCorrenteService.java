package com.felipe.project.bank.service;

import com.felipe.project.bank.interfaces.GenericCrudInterface;
import com.felipe.project.bank.model.ContaCorrente;
import com.felipe.project.bank.repository.ContaCorrenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class ContaCorrenteService implements GenericCrudInterface<ContaCorrente> {
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

    public ResponseEntity<String> depositar()
    {
        return ResponseEntity.ok("DEPOSITO CONTA CORRENTE");
    }

    public ResponseEntity<String> sacar(){
        return ResponseEntity.ok("SAQUE CONTA CORRENTE");
    }
    public ResponseEntity<String> transferir(){
        return ResponseEntity.ok("TRANSFERÊNCIA CONTA CORRENTE");
    }

}


