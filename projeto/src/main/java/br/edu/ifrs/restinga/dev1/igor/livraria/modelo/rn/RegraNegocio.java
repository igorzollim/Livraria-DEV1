/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.restinga.dev1.igor.livraria.modelo.rn;

/**
 *
 * @author igor
 */
public interface RegraNegocio<T> {
    public void validarCadastrar(T entidade);
    public void validarAtualizar(T entidadeAtinga, T entidadeNova);
    public void validarExcluir(T entidade);
}
