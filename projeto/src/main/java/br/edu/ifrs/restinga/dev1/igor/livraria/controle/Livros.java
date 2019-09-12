/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.restinga.dev1.igor.livraria.controle;

import br.edu.ifrs.restinga.dev1.igor.livraria.modelo.entidade.Livro;
import br.edu.ifrs.restinga.dev1.igor.livraria.modelo.servico.LivroServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author igor
 */
@RestController
@RequestMapping("/api")
public class Livros {
    @Autowired
    LivroServico livroServico;
    
    @PostMapping("/livros/")
    @ResponseStatus(HttpStatus.CREATED)
    public Livro cadastrarLivro(@RequestBody Livro livro){
        return livroServico.cadastrar(livro);
    }
    
    @GetMapping("/livros/")
    @ResponseStatus(HttpStatus.OK)
    public Iterable<Livro> listarLivros(){
        return livroServico.listar();
    }
    
    @PutMapping("/livros/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizarLivro(@PathVariable int id, @RequestBody Livro livro){
        livro.setId(id);
        livroServico.atualizar(livro);
    }
    
    @DeleteMapping("/livros/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluirLivro(@PathVariable int id)throws Throwable{
        livroServico.excluir(id);
    }
    
    @GetMapping("/livros/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Livro recuperarLivro(@PathVariable int id )throws Throwable{
        return livroServico.recuperar(id);
    }
}
