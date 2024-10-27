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
public class Projeto {
    private String nome;
    private String dataInicio;
    private String dataFim;
    private double margemLucro;
    
    Despesa[] listaDespesas;

    public Projeto(String nome, String dataInicio, String dataFim, double margemLucro) {
        this.nome = nome;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.margemLucro = margemLucro;
        this.listaDespesas = new Despesa[999];
    }
    
    public double calcularCusto(){
        double despesasTotais = 0;
        for (Despesa despesa:listaDespesas) {
            if (despesa == null) continue;
            despesasTotais += despesa.calcularCusto();
        }
        return despesasTotais;
    }
    
    public double calcularPrecoFinal(){
        return this.calcularCusto() * (1 + margemLucro/100) ;
    }
    
    public void adicionarDespesa(String descricao, Integer quantidadeHoras, char dificuldade){
        MaoObra despesa = new MaoObra(descricao, quantidadeHoras, dificuldade);
        for(int i=0; i <listaDespesas.length; i++) {
            if (listaDespesas[i] == null) {
                listaDespesas[i] = despesa;
                break;
            }
        }
    }
    
    public void adicionarDespesa(String descricao, double valorUnitario, Integer quantidadeItens){
        Aquisicao despesa = new Aquisicao(descricao, valorUnitario, quantidadeItens);
        for(int i=0; i <listaDespesas.length; i++) {
            if (listaDespesas[i] == null) {
                listaDespesas[i] = despesa;
                break;
            }
        }
        
    }

}
