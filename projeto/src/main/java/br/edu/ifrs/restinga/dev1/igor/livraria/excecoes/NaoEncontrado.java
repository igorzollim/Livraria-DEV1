/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.restinga.dev1.igor.livraria.excecoes;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author igor
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class NaoEncontrado extends RuntimeException {
    public NaoEncontrado(String mensagem) {
        super(mensagem);
    }
    
}

