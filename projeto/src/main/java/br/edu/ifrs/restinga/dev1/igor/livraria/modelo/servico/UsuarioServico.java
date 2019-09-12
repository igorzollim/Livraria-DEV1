/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.restinga.dev1.igor.livraria.modelo.servico;

import br.edu.ifrs.restinga.dev1.igor.livraria.excecoes.NaoEncontrado;
import br.edu.ifrs.restinga.dev1.igor.livraria.modelo.dao.TelefoneDAO;
import br.edu.ifrs.restinga.dev1.igor.livraria.modelo.dao.UsuarioDAO;
import br.edu.ifrs.restinga.dev1.igor.livraria.modelo.entidade.Telefone;
import br.edu.ifrs.restinga.dev1.igor.livraria.modelo.entidade.Usuario;
import br.edu.ifrs.restinga.dev1.igor.livraria.modelo.rn.TelefoneRN;
import br.edu.ifrs.restinga.dev1.igor.livraria.modelo.rn.UsuarioRN;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author igor
 */
@Component
public class UsuarioServico {
    
    @Autowired
    UsuarioDAO usuarioDAO;
    
    @Autowired 
    TelefoneDAO telefoneDAO;
    
    @Autowired 
    UsuarioRN usuarioRN;
    
    @Autowired
    TelefoneRN telefoneRN;
    
    public Usuario cadastrar(Usuario usuario) throws Throwable{
        usuarioRN.validar(usuario);
        telefoneRN.validarCadastrar(usuario.getTelefones());
        
        Usuario usuarioBanco = usuarioDAO.save(usuario);
        return usuarioBanco;
    }
    
    public void atualizar(Usuario usuario){
        usuarioRN.validar(usuario);
        usuarioDAO.save(usuario);
    }
    
    public Iterable<Usuario> listar(){
        return usuarioDAO.findAll();
    }
    
    public Usuario recuperar(int id) throws Throwable{
        Optional<Usuario> optionalUsuario = usuarioDAO.findById(id);
        if(!optionalUsuario.isPresent()){
            throw new NaoEncontrado("id "+id+" não foi encontrada");
        }
        return optionalUsuario.get();
    }
    
    public void excluir(int id){
        if(!usuarioDAO.existsById(id)){
            throw new NaoEncontrado("id "+id+" não foi encontrada");
        }
        usuarioDAO.deleteById(id);
    }
    
    public Telefone cadastrarTelefone(int idUsuario, Telefone telefone) throws Throwable{
        Usuario usuario = this.recuperar(idUsuario);
        telefone.setId(0);
        Telefone telefoneBanco = telefoneDAO.save(telefone);
        usuario.getTelefones().add(telefoneBanco);
        usuarioDAO.save(usuario);
        return telefoneBanco;
    }
    
    public Telefone recuperarTelefone(int idUsuario, int idTelefone)throws Throwable{
        Usuario usuario = this.recuperar(idUsuario);
        List<Telefone> telefones = usuario.getTelefones();
        
        for(Telefone telefone: telefones){
            if(telefone.getId() == idTelefone){
                return telefone;
            }
        }
        
        throw new NaoEncontrado("id "+idTelefone+" não foi encontrada");
    }
    
    public void atualizarTelefone(int idUsuario, Telefone telefone)throws Throwable{
        this.recuperarTelefone(idUsuario, telefone.getId());
        telefoneDAO.save(telefone);
    }
    
    public List<Telefone> listarTelefone(int idUsuario)throws Throwable{
        return this.recuperar(idUsuario).getTelefones();
    }
    
    public void excluirTelefone(int idUsuario, int idTelefone)throws Throwable{
        Usuario usuario = this.recuperar(idUsuario);
        List<Telefone> telefones = usuario.getTelefones();
        for(Telefone telefone: telefones){
            if(telefone.getId() == idTelefone){
                usuario.getTelefones().remove(telefone);
                usuarioDAO.save(usuario);
                return;
            }
        }
        throw new NaoEncontrado("id "+idTelefone+" nao foi encontrada");
    }
    
}
