package com.felipe.project.bank.controller;

import com.felipe.project.bank.exceptions.ErroOperacaoBancariaException;
import com.felipe.project.bank.model.ContaCorrente;
import com.felipe.project.bank.service.ContaCorrenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    @PutMapping("/deposito/{id}")
    public ResponseEntity depositar(@PathVariable("id") Long id, @RequestParam double valor) throws ErroOperacaoBancariaException {
        try{
            contaCorrenteService.depositar(id, valor);
            return ResponseEntity.ok("Depósito realizado com sucesso!");
        }catch(ErroOperacaoBancariaException ex){
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("message", ex.getMessage());
            return ResponseEntity.badRequest().body(errorResponse);
        }
    }
    @PutMapping("/saque/{id}")
    public void sacar(@PathVariable("id") Long id, @RequestParam double valor) throws ErroOperacaoBancariaException {
        contaCorrenteService.sacar(id, valor);
    }
}
