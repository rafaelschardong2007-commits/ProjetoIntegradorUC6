package com.projetointegrador.projetointegrador.repository;

import com.projetointegrador.projetointegrador.model.Aluno;
import java.util.ArrayList;
import java.util.List;

public class AlunoRepository {

    private List<Aluno> alunos = new ArrayList<>();

    public void salvar(Aluno aluno) {
        alunos.add(aluno);
    }

    public List<Aluno> listar() {
        return alunos;
    }
}
