package com.projetointegrador.projetointegrador.controller;

import com.projetointegrador.projetointegrador.model.Aluno;
import com.projetointegrador.projetointegrador.repository.AlunoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alunos")
@CrossOrigin("*")
public class AlunoController {

    private final AlunoRepository repository;

    public AlunoController(AlunoRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Aluno> listar() {
        return repository.findAll();
    }

    @PostMapping
    public Aluno salvar(@RequestBody Aluno aluno) {
        return repository.save(aluno);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        repository.deleteById(id);
    }
    @GetMapping("/admin")
public String somenteAdmin(@RequestParam String role) {
    if (!role.equals("ADMIN")) {
        throw new RuntimeException("Acesso negado");
    }
    return "Área administrativa";
}

}
