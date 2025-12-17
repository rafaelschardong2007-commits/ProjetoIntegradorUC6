package com.projetointegrador.projetointegrador.service;

import com.projetointegrador.projetointegrador.model.Aluno;
import com.projetointegrador.projetointegrador.repository.AlunoRepository;

public class AlunoService {

    public boolean validar(Aluno aluno) {
        return aluno != null
                && aluno.getNome() != null
                && aluno.getMatricula() != null;
    }
}
