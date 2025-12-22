package com.projetointegrador.projetointegrador.repository;

import com.projetointegrador.projetointegrador.model.Professor;
import java.util.ArrayList;
import java.util.List;

public class ProfessorRepository {

    private List<Professor> professores = new ArrayList<>();

    public void salvar(Professor professor) {
        professores.add(professor);
    }

    public List<Professor> listar() {
        return professores;
    }
}
