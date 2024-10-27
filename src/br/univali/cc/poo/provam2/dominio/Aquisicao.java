package br.univali.cc.poo.provam2.dominio;

public class Aquisicao extends Despesa{
    
    private double valorUnitario;
    private Integer quantidadeItens;

    public Aquisicao(String descricao, double valorUnitario, Integer quantidadeItens) {
        super(descricao);
        this.valorUnitario = valorUnitario;
        this.quantidadeItens = quantidadeItens;
    }

    @Override
    public double calcularCusto() {
        return valorUnitario * quantidadeItens;
    }
    
    
}
