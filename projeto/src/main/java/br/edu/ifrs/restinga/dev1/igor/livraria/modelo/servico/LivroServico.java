/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.restinga.dev1.igor.livraria.modelo.servico;

import br.edu.ifrs.restinga.dev1.igor.livraria.excecoes.NaoEncontrado;
import br.edu.ifrs.restinga.dev1.igor.livraria.modelo.dao.LivroDAO;
import br.edu.ifrs.restinga.dev1.igor.livraria.modelo.entidade.Livro;
import br.edu.ifrs.restinga.dev1.igor.livraria.modelo.rn.LivroRN;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author igor
 */
@Component
public class LivroServico {
    @Autowired 
    LivroDAO livroDAO;
    
    @Autowired
    LivroRN livroRN;
    
    public Livro cadastrar(Livro livro){
        livroRN.validar(livro);
        Livro livroBanco = livroDAO.save(livro);
        return livroBanco;
    }
    
    public void atualizar(Livro livro){
        livroRN.validar(livro);
        livroDAO.save(livro);
    }
    
    public Iterable<Livro> listar(){
        return livroDAO.findAll();
    }
    
    public Livro recuperar(int id) throws Throwable{
        Optional<Livro> optionalLivro = livroDAO.findById(id);
        if(!optionalLivro.isPresent()){
            throw new NaoEncontrado("id "+id+" não foi encontrada");
        }
        return optionalLivro.get();
    }
    
    public void excluir(int id){
        if(!livroDAO.existsById(id)){
            throw new NaoEncontrado("id "+id+" não foi encontrada");
        }
        livroDAO.deleteById(id);
    }
}
