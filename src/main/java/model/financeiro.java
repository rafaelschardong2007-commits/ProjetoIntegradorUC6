package com.projetointegrador.projetointegrador.model;

public class Financeiro {

    private double valor;
    private boolean pago;

    public Financeiro() {
    }

    public Financeiro(double valor, boolean pago) {
        this.valor = valor;
        this.pago = pago;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public boolean isPago() {
        return pago;
    }

    public void setPago(boolean pago) {
        this.pago = pago;
    }
}
