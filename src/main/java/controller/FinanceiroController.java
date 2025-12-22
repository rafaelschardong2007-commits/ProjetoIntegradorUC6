package com.projetointegrador.projetointegrador.controller;

import com.projetointegrador.projetointegrador.model.Financeiro;
import com.projetointegrador.projetointegrador.repository.FinanceiroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/financeiro")
@CrossOrigin(origins = "*")
public class FinanceiroController {

    @Autowired
    private FinanceiroRepository financeiroRepository;

    @PostMapping
    public Financeiro salvar(@RequestBody Financeiro financeiro) {
        return financeiroRepository.save(financeiro);
    }

    @GetMapping
    public List<Financeiro> listar() {
        return financeiroRepository.findAll();
    }
}
