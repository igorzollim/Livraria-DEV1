/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.restinga.dev1.igor.livraria.modelo.servico;

import br.edu.ifrs.restinga.dev1.igor.livraria.excecoes.NaoEncontrado;
import br.edu.ifrs.restinga.dev1.igor.livraria.modelo.dao.BibliotecarioDAO;
import br.edu.ifrs.restinga.dev1.igor.livraria.modelo.entidade.Bibliotecario;
import br.edu.ifrs.restinga.dev1.igor.livraria.modelo.rn.BibliotecarioRN;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author igor
 */
@Component
public class BibliotecarioServico {
    @Autowired
    BibliotecarioDAO bibliotecarioDAO;
    
    @Autowired
    BibliotecarioRN bibliotecarioRN;
    
    public Bibliotecario cadastrar(Bibliotecario bibliotecario){
        bibliotecarioRN.validarCadastrar(bibliotecario);
        Bibliotecario livroBanco = bibliotecarioDAO.save(bibliotecario);
        return livroBanco;
    }
    
    public void atualizar(Bibliotecario bibliotecario){
       bibliotecarioRN.validarCadastrar(bibliotecario);
        bibliotecarioDAO.save(bibliotecario);
    }
    
    public Iterable<Bibliotecario> listar(){
        return bibliotecarioDAO.findAll();
    }
    
    public Bibliotecario recuperar(int id) throws Throwable{
        Optional<Bibliotecario> optionalLivro = bibliotecarioDAO.findById(id);
        if(!optionalLivro.isPresent()){
            throw new NaoEncontrado("id "+id+" não foi encontrada");
        }
        return optionalLivro.get();
    }
    
    public void excluir(int id){
        if(!bibliotecarioDAO.existsById(id)){
            throw new NaoEncontrado("id "+id+" não foi encontrada");
        }
        bibliotecarioDAO.deleteById(id);
    }
}
