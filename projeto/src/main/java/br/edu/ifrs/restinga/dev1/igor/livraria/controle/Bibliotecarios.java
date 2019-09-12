/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.restinga.dev1.igor.livraria.controle;

import br.edu.ifrs.restinga.dev1.igor.livraria.modelo.entidade.Bibliotecario;
import br.edu.ifrs.restinga.dev1.igor.livraria.modelo.entidade.Emprestimo;
import br.edu.ifrs.restinga.dev1.igor.livraria.modelo.servico.BibliotecarioServico;
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
public class Bibliotecarios {
    @Autowired
    BibliotecarioServico bibliotecarioServico;
    
    @PostMapping("/bibliotecarios/")
    @ResponseStatus(HttpStatus.CREATED)
    public Bibliotecario cadastrarBibliotecario(@RequestBody Bibliotecario bibliotecario){
        return bibliotecarioServico.cadastrar(bibliotecario);
    }
    
    @GetMapping("/bibliotecarios/")
    @ResponseStatus(HttpStatus.OK)
    public Iterable<Bibliotecario> listarBibliotecarios(){
        return bibliotecarioServico.listar();
    }
    
   @PutMapping("/bibliotecarios/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizarBibliotecario(@PathVariable int id, @RequestBody Bibliotecario bibliotecario){
        bibliotecario.setId(id);
        bibliotecarioServico.atualizar(bibliotecario);
    }
    
     @DeleteMapping("/bibliotecarios/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void excluirBibliotecario(@PathVariable int id) throws Throwable{
        bibliotecarioServico.excluir(id);
    }
    
    @GetMapping("/bibliotecarios/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Bibliotecario recuperarBibliotecario(@PathVariable int id) throws Throwable{
        return bibliotecarioServico.recuperar(id);
    }
}
