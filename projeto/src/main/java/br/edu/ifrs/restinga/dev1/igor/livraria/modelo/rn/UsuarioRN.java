/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.restinga.dev1.igor.livraria.modelo.rn;

import br.edu.ifrs.restinga.dev1.igor.livraria.excecoes.QuebraRegraNegocio;
import br.edu.ifrs.restinga.dev1.igor.livraria.modelo.dao.UsuarioDAO;
import br.edu.ifrs.restinga.dev1.igor.livraria.modelo.entidade.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author igor
 */
@Component
public class UsuarioRN implements RegraNegocio<Usuario> {
    
    @Autowired
    UsuarioDAO usuarioDAO;
    
    public void validar(Usuario usuario){
        if(usuario.getCpf() == null || usuario.getCpf().equals("") ){
            throw new QuebraRegraNegocio("O CPF é obrigatório");
        }
        
        if ( usuario.getEmail()== null || usuario.getEmail().equals("") ){
            throw new QuebraRegraNegocio("O e-mail é obrigatório");
        }
        
        if(usuario.getNome() == null || usuario.getNome().equals("") ){
            throw new QuebraRegraNegocio("O nome é obrigatório");
        }
        
        if (emailRepetido(usuario)){
            throw new QuebraRegraNegocio("E-mail não pode ser repetido");
        }
        
         if (cpfRepetido(usuario)){
            throw new QuebraRegraNegocio("CPF não pode ser repetido");
        }
    }
    
    private boolean emailRepetido(Usuario usuario){
        Iterable<Usuario> findAll = usuarioDAO.findAll();
        
        for (Usuario usuarioBanco : findAll){
            if (usuario.getEmail().equals(usuarioBanco.getEmail())){
                return true;
            }
        }
        return false;
    }
    
    private boolean cpfRepetido(Usuario usuario){
        Iterable<Usuario> findAll = usuarioDAO.findAll();
        
        for (Usuario usuarioBanco : findAll){
            if (usuario.getCpf().equals(usuarioBanco.getCpf())){
                return true;
            }
        }
        return false;
    }
    
    @Override
    public void validarCadastrar(Usuario usuario){
        validar(usuario);
    }
    
    @Override
    public void validarAtualizar(Usuario entidadeAntiga, Usuario entidadeNova){
        validar(entidadeNova);
    }
    
    @Override
    public void validarExcluir(Usuario usuario){
        
    }
}
