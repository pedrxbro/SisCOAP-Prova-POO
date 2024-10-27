/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univali.cc.poo.provam2.dominio;

/**
 *
 * @author 8112363
 */
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
