package com.projetointegrador.projetointegrador.model;

import jakarta.persistence.*;

@Entity
@Table(name = "professores")
public class Professor extends Pessoa {

    private String especialidade;

    public Professor() {}

    public Professor(String nome, String email, String telefone, String especialidade) {
        super(nome, email, telefone);
        this.especialidade = especialidade;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }
}
