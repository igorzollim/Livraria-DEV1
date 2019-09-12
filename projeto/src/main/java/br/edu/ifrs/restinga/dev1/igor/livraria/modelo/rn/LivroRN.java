/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.restinga.dev1.igor.livraria.modelo.rn;

import br.edu.ifrs.restinga.dev1.igor.livraria.excecoes.QuebraRegraNegocio;
import br.edu.ifrs.restinga.dev1.igor.livraria.modelo.entidade.Livro;
import org.springframework.stereotype.Component;

/**
 *
 * @author igor
 */
@Component
public class LivroRN implements RegraNegocio<Livro>{
    public void validar(Livro livro) {
       if(livro.getTitulo() == null || livro.getTitulo().equals("")){
           throw new QuebraRegraNegocio("O titulo é obrigatório");
       }
       
       if(livro.getAnoPublicacao() == 0){
            throw new QuebraRegraNegocio("O ano de publicação é obrigatório");
       }
    }

    @Override
    public void validarCadastrar(Livro entidade) {
        validar(entidade);
    }

    @Override
    public void validarAtualizar(Livro entidadeAtinga, Livro entidadeNova) {
        validar(entidadeNova);
    }

    @Override
    public void validarExcluir(Livro entidade) {
        
    }
}
