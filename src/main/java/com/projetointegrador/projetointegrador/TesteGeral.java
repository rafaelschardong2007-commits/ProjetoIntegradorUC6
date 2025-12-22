package com.projetointegrador.projetointegrador;

import com.projetointegrador.projetointegrador.model.*;
import com.projetointegrador.projetointegrador.service.*;

public class TesteGeral {

    public static void main(String[] args) {

        System.out.println("=== TESTE DO SISTEMA ===");

        
        Aluno aluno = new Aluno(
                "Rafael",
                "12345678900",
                "rafael@email.com"
        );

        AlunoService alunoService = new AlunoService();
        alunoService.cadastrar(aluno);


      
        Professor professor = new Professor(
                "Carlos",
                "98765432100",
                "Matemática"
        );

        System.out.println("Professor criado: " + professor.getNome());

       
        Livro livro = new Livro(
                "Java para Iniciantes",
                "Deitel"
        );

        System.out.println("Livro: " + livro.getTitulo() + " - Autor: " + livro.getAutor());

       
        Financeiro financeiro = new Financeiro(
                aluno,
                1200.00,
                true
        );

        FinanceiroService financeiroService = new FinanceiroService();
        financeiroService.registrarPagamento(financeiro);

       
        Usuario usuario = new Usuario(
                "admin",
                "1234"
        );

        UsuarioService usuarioService = new UsuarioService();
        usuarioService.cadastrar(usuario);

        System.out.println("=== FIM DOS TESTES ===");
    }
}
