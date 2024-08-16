package com.felipe.project.bank.controller;

import com.felipe.project.bank.model.Conta;
import com.felipe.project.bank.service.ContaBancariaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/conta")
public class ContaBancariaController {
    @Autowired
    private ContaBancariaService contaBancariaService;
    @PostMapping("/")
    public void create(@RequestBody Conta conta){
        contaBancariaService.save(conta);
    }
    @GetMapping("/{id}")
    public Conta getContaById(@PathVariable("id") long id){
        return contaBancariaService.findById(id);
    }
    @GetMapping("/")
    public List<Conta> getAllConta(){
        return contaBancariaService.findAll();
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Long id){
        contaBancariaService.delete(id);
    }
}
