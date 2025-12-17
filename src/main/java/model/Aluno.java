package com.projetointegrador.projetointegrador.model;

public class Aluno extends Pessoa {

    private String matricula;

    public Aluno() {
    }

    public Aluno(String nome, String cpf, String matricula) {
        super(nome, cpf);
        this.matricula = matricula;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
}
