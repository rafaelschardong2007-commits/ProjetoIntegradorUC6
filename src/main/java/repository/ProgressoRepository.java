package com.projetointegrador.projetointegrador.repository;

import com.projetointegrador.projetointegrador.model.Progresso;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProgressoRepository extends JpaRepository<Progresso, Long> {

    List<Progresso> findByAlunoId(Long alunoId);
}
