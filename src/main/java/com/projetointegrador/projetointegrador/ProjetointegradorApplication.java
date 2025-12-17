package com.projetointegrador.projetointegrador;

import com.projetointegrador.projetointegrador.model.Aluno;
import com.projetointegrador.projetointegrador.model.Financeiro;
import com.projetointegrador.projetointegrador.model.Usuario;
import com.projetointegrador.projetointegrador.service.AlunoService;
import com.projetointegrador.projetointegrador.service.FinanceiroService;
import com.projetointegrador.projetointegrador.service.UsuarioService;

public class ProjetointegradorApplication {

    public static void main(String[] args) {

        Usuario usuario = new Usuario("Rafael");
        UsuarioService usuarioService = new UsuarioService();
        usuarioService.cadastrar(usuario);

        Aluno aluno = new Aluno("João");
        AlunoService alunoService = new AlunoService();
        alunoService.cadastrar(aluno);

        Financeiro financeiro = new Financeiro(150.0);
        FinanceiroService financeiroService = new FinanceiroService();
        financeiroService.processar(financeiro);
    }
}
