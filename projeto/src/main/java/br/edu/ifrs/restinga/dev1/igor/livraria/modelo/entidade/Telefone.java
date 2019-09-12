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
public class Telefone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String tipo;
    private int numero;
    private int area;
    private int ramal;

    public int getId() {
        return id;
    }

    public String getTipo() {
        return tipo;
    }

    public int getNumero() {
        return numero;
    }

    public int getArea() {
        return area;
    }

    public int getRamal() {
        return ramal;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public void setRamal(int ramal) {
        this.ramal = ramal;
    }
}
