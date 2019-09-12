/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.restinga.dev1.igor.livraria.modelo.entidade;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author igor
 */

@Entity
public class Emprestimo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Temporal(TemporalType.DATE)
    private Date retirada;
    
    @Temporal(TemporalType.DATE)
    private Date previsaoDevolucao;
    
    @Temporal(TemporalType.DATE)
    private Date devolucao;
    
    @ManyToOne
    private Bibliotecario bibliotecario;
    
    @ManyToOne
    private Usuario usuario;
    
    @ManyToOne
    private Livro livro;

    public void setId(int id) {
        this.id = id;
    }

    public void setRetirada(Date retirada) {
        this.retirada = retirada;
    }

    public void setPrevisaoDevolucao(Date previsaoDevolucao) {
        this.previsaoDevolucao = previsaoDevolucao;
    }

    public void setDevolucao(Date devolucao) {
        this.devolucao = devolucao;
    }

    public void setBibliotecario(Bibliotecario bibliotecario) {
        this.bibliotecario = bibliotecario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public int getId() {
        return id;
    }

    public Date getRetirada() {
        return retirada;
    }

    public Date getPrevisaoDevolucao() {
        return previsaoDevolucao;
    }

    public Date getDevolucao() {
        return devolucao;
    }

    public Bibliotecario getBibliotecario() {
        return bibliotecario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Livro getLivro() {
        return livro;
    }
    
    
}
