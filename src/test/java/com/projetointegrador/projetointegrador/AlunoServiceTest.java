
package com.projetointegrador.projetointegrador;

import com.projetointegrador.projetointegrador.model.Aluno;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AlunoServiceTest {

    @Test
    void deveCriarAlunoComNomeCorreto() {
        // Arrange (preparação)
        AlunoService alunoService = new AlunoService();

        // Act (ação)
        Aluno aluno = alunoService.criarAluno("Rafael");

        // Assert (verificação)
        assertNotNull(aluno);
        assertEquals("Rafael", aluno.getNome());
    }
}
