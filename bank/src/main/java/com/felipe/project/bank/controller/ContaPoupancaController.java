package com.felipe.project.bank.controller;

import com.felipe.project.bank.model.ContaPoupanca;
import com.felipe.project.bank.service.ContaPoupancaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contapoupanca")
public class ContaPoupancaController {
    @Autowired
    private ContaPoupancaService contaPoupancaService;
    @PostMapping("/")
    public void create(@RequestBody ContaPoupanca conta){
        contaPoupancaService.save(conta);
    }
    @GetMapping("/{id}")
    public ContaPoupanca getContaPoupancaById(@PathVariable("id") long id){
        return contaPoupancaService.findById(id);
    }
    @GetMapping("/")
    public List<ContaPoupanca> getAllContaPoupanca(){
        return contaPoupancaService.findAll();
    }
    @DeleteMapping("/{id}")
    public void deleteContaPoupancaById(@PathVariable("id") Long id){
        contaPoupancaService.delete(id);
    }

    // MÉTODOS A SEREM AINDA IMPLEMENTADOS
    @GetMapping("/deposito")
    public void depositar(){
        contaPoupancaService.depositar();
    }
    @GetMapping("/transferencia")
    public void transferir(){
        contaPoupancaService.transferir();
    }
    @GetMapping("/saque")
    public void sacar(){
        contaPoupancaService.sacar();
    }
}
