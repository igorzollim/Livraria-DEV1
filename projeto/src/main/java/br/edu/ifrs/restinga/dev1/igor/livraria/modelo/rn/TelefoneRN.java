/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.restinga.dev1.igor.livraria.modelo.rn;

import br.edu.ifrs.restinga.dev1.igor.livraria.excecoes.QuebraRegraNegocio;
import br.edu.ifrs.restinga.dev1.igor.livraria.modelo.dao.UsuarioDAO;
import br.edu.ifrs.restinga.dev1.igor.livraria.modelo.entidade.Telefone;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author igor
 */
@Component
public class TelefoneRN {
    
    @Autowired
    UsuarioDAO usuarioDAO;
    
    private void validar(List<Telefone> telefones){
        if(telefones.isEmpty()){
            throw new QuebraRegraNegocio("O campo telefones é obrigatorio");
        }
        
        if(telefones.size() > 3){
             throw new QuebraRegraNegocio("Não pode ter mais de 3 telefones");
        }
    }
    
   
    
    public void validarCadastrar(List<Telefone> telefones){
        validar(telefones);
    }
}
