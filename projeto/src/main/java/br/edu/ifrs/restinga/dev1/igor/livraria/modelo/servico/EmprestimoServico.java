/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.restinga.dev1.igor.livraria.modelo.servico;

import br.edu.ifrs.restinga.dev1.igor.livraria.excecoes.NaoEncontrado;
import br.edu.ifrs.restinga.dev1.igor.livraria.modelo.dao.EmprestimoDAO;
import br.edu.ifrs.restinga.dev1.igor.livraria.modelo.entidade.Emprestimo;
import br.edu.ifrs.restinga.dev1.igor.livraria.modelo.rn.EmprestimoRN;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author igor
 */
@Component
public class EmprestimoServico {
    @Autowired 
    EmprestimoDAO emprestimoDAO;
    
    @Autowired
    EmprestimoRN emprestimoRN;
    
    public Emprestimo cadastrar(Emprestimo emprestimo){
        emprestimoRN.validarCadastrar(emprestimo);
        Emprestimo emprestimoBanco = emprestimoDAO.save(emprestimo);
        return emprestimoBanco;
    }
    
    public void atualizar(Emprestimo emprestimo){
        emprestimoRN.validarAtualizar(emprestimo, emprestimo);
        emprestimoDAO.save(emprestimo);
    }
    
    public Iterable<Emprestimo> listar(){
        return emprestimoDAO.findAll();
    }
    
    public Emprestimo recuperar(int id) throws Throwable{
        Optional<Emprestimo> optionalEmprestimo = emprestimoDAO.findById(id);
        if(!optionalEmprestimo.isPresent()){
            throw new NaoEncontrado("id "+id+" não foi encontrada");
        }
        return optionalEmprestimo.get();
    }
    
    public void excluir(int id){
        if(!emprestimoDAO.existsById(id)){
            throw new NaoEncontrado("id "+id+" não foi encontrada");
        }
        emprestimoDAO.deleteById(id);
    }
}
