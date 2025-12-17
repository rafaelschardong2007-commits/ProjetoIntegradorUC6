package com.projetointegrador.projetointegrador.service;

import com.projetointegrador.projetointegrador.model.Financeiro;

public class FinanceiroService {

    public double calcularValorFinal(Financeiro financeiro) {
        if (financeiro.isPago()) {
            return financeiro.getValor() * 0.9;
        }
        return financeiro.getValor();
    }
}
