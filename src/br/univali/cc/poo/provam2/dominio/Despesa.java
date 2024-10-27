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
public abstract class Despesa {
    protected String descricao;

    public Despesa(String descricao) {
        this.descricao = descricao;
    }
    
    public abstract double calcularCusto();
}
