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
public class MaoObra extends Despesa{
    private Integer quantidadeHoras;
    private char dificuldade;

    public MaoObra(String descricao,Integer quantidadeHoras, char dificuldade) {
        super(descricao);
        this.quantidadeHoras = quantidadeHoras;
        this.dificuldade = dificuldade;
    }

   

    @Override
    public double calcularCusto() {
        switch (dificuldade) {
            case 'F':
                return quantidadeHoras * 10;
            case 'M':
                return quantidadeHoras * 25;
            default:
                return quantidadeHoras * 50;
        }
    }
    
    
    
}
