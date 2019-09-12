/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.restinga.dev1.igor.livraria.controle;

import br.edu.ifrs.restinga.dev1.igor.livraria.modelo.entidade.Emprestimo;
import br.edu.ifrs.restinga.dev1.igor.livraria.modelo.servico.EmprestimoServico;
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
public class Emprestimos {
    @Autowired
    EmprestimoServico emprestimoServico;
    
    @PostMapping("/emprestimos/")
    @ResponseStatus(HttpStatus.CREATED)
    public Emprestimo cadastrarEmprestimo(@RequestBody Emprestimo emprestimo){
        return emprestimoServico.cadastrar(emprestimo);
    }
    
    @GetMapping("/emprestimos/")
    @ResponseStatus(HttpStatus.OK)
    public Iterable<Emprestimo> listarEmprestimos(){
        return emprestimoServico.listar();
    }
    
    @PutMapping("/emprestimos/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizarEmprestimo(@PathVariable int id, @RequestBody Emprestimo emprestimo){
        emprestimo.setId(id);
        emprestimoServico.atualizar(emprestimo);
    }
    
    @DeleteMapping("/emprestimos/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void excluirEmprestimo(@PathVariable int id) throws Throwable{
        emprestimoServico.excluir(id);
    }
    
    @GetMapping("/emprestimos/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Emprestimo recuperarEmprestimo(@PathVariable int id) throws Throwable{
        return emprestimoServico.recuperar(id);
    }
}
