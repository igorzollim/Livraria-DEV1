/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.restinga.dev1.igor.livraria.controle;

import br.edu.ifrs.restinga.dev1.igor.livraria.modelo.entidade.Telefone;
import br.edu.ifrs.restinga.dev1.igor.livraria.modelo.entidade.Usuario;
import br.edu.ifrs.restinga.dev1.igor.livraria.modelo.servico.UsuarioServico;
import java.util.List;
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
public class Usuarios {
    @Autowired
    UsuarioServico usuarioServico;
    
    @PostMapping("/usuarios/")
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario cadastrarUsuario(@RequestBody Usuario usuario){
        return usuarioServico.cadastrar(usuario);
    }
    
    @GetMapping("/usuarios/")
    @ResponseStatus(HttpStatus.OK)
    public Iterable<Usuario> listarUsuarios(){
        return usuarioServico.listar();
    }
    
    @PutMapping("/usuarios/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizarUsuario(@PathVariable int id, @RequestBody Usuario usuario){
        usuario.setId(id);
        usuarioServico.atualizar(usuario);
    }
    
    @DeleteMapping("/usuarios/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluirUsuario(@PathVariable int id) throws Throwable{
        usuarioServico.excluir(id);
    }
    
    @GetMapping("/usuarios/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Usuario recuperarUsuario(@PathVariable int id) throws Throwable{
        return usuarioServico.recuperar(id);
    }
    
    @PostMapping("/usuarios/{idUsuario}/telefones")
    @ResponseStatus(HttpStatus.CREATED)
    public Telefone cadastrarTelefone(@PathVariable int idUsuario, @RequestBody Telefone telefone) throws Throwable{
        return usuarioServico.cadastrarTelefone(idUsuario, telefone);
    }
    
    @PutMapping("/usuarios/{idUsuario}/telefones/{idTelefone}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizarTelefone(@PathVariable int idUsuario, @PathVariable int idTelefone, @RequestBody Telefone telefone)throws Throwable{
        telefone.setId(idTelefone);
        usuarioServico.atualizarTelefone(idUsuario, telefone);
    }
    
    @DeleteMapping("/usuarios/{idUsuario}/telefones/{idTelefone}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluirTelefone(@PathVariable int idUsuario, @PathVariable int idTelefone)throws Throwable{
        usuarioServico.excluirTelefone(idUsuario, idTelefone);
    }
    
    @GetMapping("/usuarios/{idUsuario}/telefones/{idTelefone}")
    @ResponseStatus(HttpStatus.OK)
    public Telefone recuperarTelefone(@PathVariable int idUsuario, @PathVariable int idTelefone)throws Throwable{
        return usuarioServico.recuperarTelefone(idUsuario, idTelefone);
    }
    
    @GetMapping("/usuarios/{idUsuario}/telefones/")
    @ResponseStatus(HttpStatus.OK)
    public List<Telefone> listarTelefone(@PathVariable int idUsuario) throws Throwable{
        return usuarioServico.listarTelefone(idUsuario);
    }
}
