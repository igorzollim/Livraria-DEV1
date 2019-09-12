/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.restinga.dev1.igor.livraria.modelo.rn;

import br.edu.ifrs.restinga.dev1.igor.livraria.excecoes.QuebraRegraNegocio;
import br.edu.ifrs.restinga.dev1.igor.livraria.modelo.dao.BibliotecarioDAO;
import br.edu.ifrs.restinga.dev1.igor.livraria.modelo.entidade.Bibliotecario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author igor
 */
@Component
public class BibliotecarioRN implements RegraNegocio<Bibliotecario> {
    
    @Autowired
    BibliotecarioDAO bibliotecarioDAO;
    
    @Override
    public void validarCadastrar(Bibliotecario bibliotecario) {
        if (bibliotecario.getEmail() == null || bibliotecario.getEmail().equals("")){
             throw new QuebraRegraNegocio("O campo e-mail deve ser obrigatório");
        }
        
        if(bibliotecario.getNome()== null || bibliotecario.getNome().equals("")){
            throw new QuebraRegraNegocio("O nome deve ser obrigatório");
        }
        
        if(bibliotecario.getSenha()== null || bibliotecario.getSenha().equals("")){
             throw new QuebraRegraNegocio("A senha é obrigatória");
        }
        
        if (bibliotecario.getSenha().length() < 8){
             throw new QuebraRegraNegocio("A senha deve ter no mínimo 8 caracteres");
        }
        
        if (emailRepetido(bibliotecario)){
             throw new QuebraRegraNegocio("e-mail não pode ser repetido");
        }
    }
    
    private boolean emailRepetido(Bibliotecario bibliotecario){
        Iterable<Bibliotecario> findAll = bibliotecarioDAO.findAll();
        for (Bibliotecario bibliotecarioBanco : findAll){
            if (bibliotecario.getEmail().equals(bibliotecarioBanco.getEmail())){
                return true;
            }
        }
        return false;
    }

    @Override
    public void validarAtualizar(Bibliotecario entidadeAntiga, Bibliotecario entidadeAntigaNova) {
      

    }

    @Override
    public void validarExcluir(Bibliotecario entidade) {
      
    }
}
