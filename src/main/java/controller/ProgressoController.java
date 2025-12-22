package com.projetointegrador.projetointegrador.controller;

import com.projetointegrador.projetointegrador.model.Progresso;
import com.projetointegrador.projetointegrador.repository.ProgressoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/progresso")
@CrossOrigin("*")
public class ProgressoController {

    private final ProgressoRepository repository;

    public ProgressoController(ProgressoRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public Progresso salvar(@RequestBody Progresso progresso) {
        return repository.save(progresso);
    }

    @GetMapping("/{alunoId}")
    public List<Progresso> listar(@PathVariable Long alunoId) {
        return repository.findByAlunoId(alunoId);
    }
}
