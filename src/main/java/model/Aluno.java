package com.projetointegrador.projetointegrador.model;

import jakarta.persistence.*;

@Entity
@Table(name = "alunos")
public class Aluno extends Pessoa {

    @Column(nullable = false, unique = true)
    private String matricula;

    public Aluno() {}

    public Aluno(String nome, String email, String telefone, String matricula) {
        super(nome, email, telefone);
        this.matricula = matricula;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
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

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }
}
