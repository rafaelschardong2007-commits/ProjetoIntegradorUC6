package com.projetointegrador.projetointegrador.service;

import com.projetointegrador.projetointegrador.model.Financeiro;

public class FinanceiroService {

    public double aplicarDesconto(Financeiro financeiro, double percentual) {
        if (percentual < 0 || percentual > 100) {
            throw new IllegalArgumentException("Percentual inválido");
        }

        double desconto = financeiro.getValor() * (percentual / 100);
        return financeiro.getValor() - desconto;
    }

    public void registrarPagamento(Financeiro financeiro) {
        financeiro.setPago(true);
    }
}
