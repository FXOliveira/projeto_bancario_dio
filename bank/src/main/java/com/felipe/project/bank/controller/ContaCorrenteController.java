package com.felipe.project.bank.controller;

import com.felipe.project.bank.exceptions.ErroOperacaoBancariaException;
import com.felipe.project.bank.model.ContaCorrente;
import com.felipe.project.bank.service.ContaCorrenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contacorrente")
public class ContaCorrenteController {
    @Autowired
    private ContaCorrenteService contaCorrenteService;
    @PostMapping("/")
    public void create(@RequestBody ContaCorrente conta){
        contaCorrenteService.save(conta);
    }
    @GetMapping("/{id}")
    public ContaCorrente getContaCorrenteById(@PathVariable("id") long id){
        return contaCorrenteService.findById(id);
    }
    @GetMapping("/")
    public List<ContaCorrente> getAllContaCorrente(){
        return contaCorrenteService.findAll();
    }
    @DeleteMapping("/{id}")
    public void deleteContaCorrenteById(@PathVariable("id") Long id){
        contaCorrenteService.delete(id);
    }

    @GetMapping("/deposito/{id}")
    public void depositar(@PathVariable("id") Long id, @RequestBody double valor) throws ErroOperacaoBancariaException {
        contaCorrenteService.depositar(id, valor);
    }
    @GetMapping("/saque/{id}")
    public void sacar(@PathVariable("id") Long id, @RequestBody double valor){
        contaCorrenteService.sacar(id, valor);
    }
}
