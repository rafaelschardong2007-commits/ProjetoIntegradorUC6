package com.projetointegrador.projetointegrador.model;

import jakarta.persistence.*;

@Entity
@Table(name = "progresso")
public class Progresso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long alunoId;

    private int licaoId;

    private boolean concluido;

    public Progresso() {}

    public Progresso(Long alunoId, int licaoId, boolean concluido) {
        this.alunoId = alunoId;
        this.licaoId = licaoId;
        this.concluido = concluido;
    }

    public Long getId() {
        return id;
    }

    public Long getAlunoId() {
        return alunoId;
    }

    public void setAlunoId(Long alunoId) {
        this.alunoId = alunoId;
    }

    public int getLicaoId() {
        return licaoId;
    }

    public void setLicaoId(int licaoId) {
        this.licaoId = licaoId;
    }

    public boolean isConcluido() {
        return concluido;
    }

    public void setConcluido(boolean concluido) {
        this.concluido = concluido;
    }
}
