package com.projetointegrador.projetointegrador.service;

import com.projetointegrador.projetointegrador.model.Aluno;

public class AlunoService {

    public void cadastrar(Aluno aluno) {
        System.out.println("Aluno cadastrado: " + aluno.getNome());
    }
}
