package com.projetointegrador.projetointegrador.repository;

import com.projetointegrador.projetointegrador.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
}
