package com.projetointegrador.projetointegrador.controller;

import com.projetointegrador.projetointegrador.model.Livro;
import com.projetointegrador.projetointegrador.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livros")
@CrossOrigin(origins = "*")
public class LivroController {

    @Autowired
    private LivroRepository livroRepository;

    @PostMapping
    public Livro salvar(@RequestBody Livro livro) {
        return livroRepository.save(livro);
    }

    @GetMapping
    public List<Livro> listar() {
        return livroRepository.findAll();
    }
}
