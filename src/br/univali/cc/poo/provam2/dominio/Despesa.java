package br.univali.cc.poo.provam2.dominio;

public abstract class Despesa {
    protected String descricao;

    public Despesa(String descricao) {
        this.descricao = descricao;
    }
    
    public abstract double calcularCusto();
}
