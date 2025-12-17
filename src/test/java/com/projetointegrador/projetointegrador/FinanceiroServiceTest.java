
package com.projetointegrador.projetointegrador;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FinanceiroServiceTest {

    @Test
    public void deveCalcularTotalCorretamente() {
        financeiroService service = new financeiroService();
        double resultado = service.calcularTotal(100.0, 2);
        assertEquals(200.0, resultado);
    }

    @Test
    public void deveLancarExcecaoParaValoresInvalidos() {
        financeiroService service = new financeiroService();
        assertThrows(IllegalArgumentException.class, () -> {
            service.calcularTotal(-10, 2);
        });
    }
}