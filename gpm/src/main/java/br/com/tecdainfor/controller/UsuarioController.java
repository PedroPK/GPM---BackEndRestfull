package br.com.tecdainfor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import br.com.tecdainfor.dao.UsuarioDAO;
import br.com.tecdainfor.model.Computador;
import br.com.tecdainfor.model.Usuario;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	UsuarioDAO usuariodao;
	
	
	
	//Recebimento e tratamento dos dados via HTTP.
	
	@RequestMapping(value = "/lista", method= RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody List<Usuario> ConsultarTodos(){
		return 	this.usuariodao.listarUsuarios();
	}
	
	@RequestMapping(value = "/cadastrar", method = RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody Usuario salvar(@RequestBody Usuario usuario) {
		return this.usuariodao.cadastrarUsuario(usuario);				
	}
	
	@RequestMapping(value = "/alterar", method = RequestMethod.PUT, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody Usuario editar(@RequestBody Usuario usuario){
		usuariodao.alterarUsuario(usuario);
		return usuario;
	}
	
	@RequestMapping (value = "/buscar/{nome}", method= RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody List<Usuario> consultarUsuarioNome(@PathVariable String nome){
		List<Usuario> usuario = usuariodao.consultarUsuarioNome(nome);
		return usuario;
	}
	
	@RequestMapping (value = "/excluir/{id}", method = RequestMethod.DELETE,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody Usuario excluir(@PathVariable int id){
		return this.usuariodao.excluir(id);
	}
	
	@RequestMapping(value="/consultar/{id}", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody Usuario buscar(@PathVariable("id") Integer id){
 
		return this.usuariodao.consultarUsuarioCodigo(id);
	}

}
