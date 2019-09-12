/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.restinga.dev1.igor.livraria.modelo.rn;

import br.edu.ifrs.restinga.dev1.igor.livraria.excecoes.QuebraRegraNegocio;
import br.edu.ifrs.restinga.dev1.igor.livraria.modelo.dao.EmprestimoDAO;
import br.edu.ifrs.restinga.dev1.igor.livraria.modelo.dao.LivroDAO;
import br.edu.ifrs.restinga.dev1.igor.livraria.modelo.entidade.Emprestimo;
import br.edu.ifrs.restinga.dev1.igor.livraria.modelo.entidade.Livro;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author igor
 */
@Component
public class EmprestimoRN implements RegraNegocio<Emprestimo>{
    
    @Autowired
    EmprestimoDAO emprestimoDAO;
    
    public void validar(Emprestimo emprestimo) {
      if (emprestimo.getBibliotecario() == null){
         throw new QuebraRegraNegocio("Bibliotecario é obrigatório");
      }
      
      if (emprestimo.getLivro() == null){
           throw new QuebraRegraNegocio("Livro é obrigatório");
      }
      
      if (emprestimo.getUsuario() == null ){
           throw new QuebraRegraNegocio("Usuario é obrigatório");
      }
      
      if (emprestimo.getDevolucao() != null){
          if (emprestimo.getDevolucao()== null || !dataDevolucaoValida(emprestimo.getDevolucao())){
             throw new QuebraRegraNegocio("Data de devolução deve ser igual ou menor que a data atual");
         }
      }
      
      //Colocando a data de retirada como data atual
      Date dataAtual = new Date(System.currentTimeMillis());
      emprestimo.setRetirada(dataAtual);
      
      //Colocando a data prevista de devolução
      Calendar c = Calendar.getInstance();
      c.setTime(dataAtual);
      c.add(Calendar.DATE, +7);
      Date dataPrevistaDevolucao = c.getTime();
      emprestimo.setPrevisaoDevolucao(dataPrevistaDevolucao);
      
    }
    
   private void livroEmprestado(Livro livro){
       Iterable<Emprestimo> findAll = emprestimoDAO.findAll();
       for (Emprestimo emprestimo : findAll){
           if (emprestimo.getLivro().getId() == livro.getId() && emprestimo.getDevolucao() == null){
               throw new QuebraRegraNegocio("Não pode fazer empréstimo de um livro que não foi devolvido");
           }
       }
   }
    
    private boolean dataDevolucaoValida(Date dataDevolucao){
        Date dataAtual = new Date(System.currentTimeMillis());
        
        if (dataDevolucao.before(dataAtual) || dataDevolucao.equals(dataAtual)){
            return true;
        } else{
            return false;
        }
      
        
    }

    @Override
    public void validarCadastrar(Emprestimo entidade) {
        validar(entidade);
        livroEmprestado(entidade.getLivro());
    }

   @Override
    public void validarAtualizar(Emprestimo entidadeAntiga, Emprestimo entidadeNova) {
        validar(entidadeNova);
    }

    @Override
    public void validarExcluir(Emprestimo entidade) {
        
    }
}
