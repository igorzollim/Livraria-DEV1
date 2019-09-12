/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.restinga.dev1.igor.livraria.modelo.entidade;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author igor
 */
@Entity
public class Livro {
     @Id
    @GeneratedValue(strategy = 
         GenerationType.IDENTITY)
    private int id;
     
     private String titulo;
     private int anoPublicacao;
     private boolean doacao;

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    public boolean isDoacao() {
        return doacao;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAnoPublicacao(int anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    public void setDoacao(boolean doacao) {
        this.doacao = doacao;
    }
     
}
