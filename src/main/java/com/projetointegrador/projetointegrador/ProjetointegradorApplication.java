package com.projetointegrador.projetointegrador;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProjetointegradorApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetointegradorApplication.class, args);
                
                Aluno aluno = new Aluno("Rafael", 18, "A001");
        AlunoService alunoService = new AlunoService();
        AlunoRepository alunoRepository = new AlunoRepository();

        if (alunoService.validarAluno(aluno)) {
            alunoRepository.salvar(aluno);
            System.out.println("Aluno cadastrado com sucesso!");
        } else {
            System.out.println("Aluno inválido!");
        }

        System.out.println("Total de alunos: " + alunoRepository.listar().size());

        // TESTE FINANCEIRO
        Financeiro financeiro = new Financeiro(500.0, true);
        FinanceiroService financeiroService = new FinanceiroService();

        System.out.println("Pagamento efetuado: " + financeiroService.verificarPagamento(financeiro));
        System.out.println("Valor com desconto: " + financeiroService.calcularDesconto(financeiro));
                
                
                
	}

}
