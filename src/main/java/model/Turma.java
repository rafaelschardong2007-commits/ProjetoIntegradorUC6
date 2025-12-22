package com.projetointegrador.projetointegrador.model;

public class Turma {

    private String nome;
    private Professor professor;

    public Turma() {}

    public Turma(String nome, Professor professor) {
        this.nome = nome;
        this.professor = professor;
    }

    public String getNome() {
        return nome;
    }

    public Professor getProfessor() {
        return professor;
    }
}
