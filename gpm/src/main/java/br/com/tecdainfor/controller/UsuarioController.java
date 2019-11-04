package br.com.tecdainfor.controller;

import java.util.List;

import javax.swing.JOptionPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import br.com.tecdainfor.model.ResponseModel;
import br.com.tecdainfor.model.Usuario;
import br.com.tecdainfor.service.UsuarioService;

@CrossOrigin
@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	
	private int matricula;
	private String senha;
	
	@Autowired
	private UsuarioService usuarioService;
	
	
	// Recebimento e tratamento dos dados via HTTP.

	@RequestMapping(value = "/lista", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody List<Usuario> ConsultarTodos() {
		return this.usuarioService.findAll();
	}

	@RequestMapping(value = "/cadastrar", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody ResponseModel salvar(@RequestBody Usuario usuario) {

		try {

			this.usuarioService.save(usuario);

			return new ResponseModel(1, "Registro salvo com sucesso!");

		} catch (Exception e) {

			return new ResponseModel(0, e.getMessage());
		}

	}

	@RequestMapping(value = "/alterar", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody ResponseModel editar(@RequestBody Usuario usuario) {
		
		try {

			this.usuarioService.save(usuario);

			return new ResponseModel(1, "Registro Atualizado com sucesso!");

		} catch (Exception e) {

			return new ResponseModel(0, e.getMessage());
		}

	}
		
	

	@RequestMapping(value = "/buscar/{nome}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody List<Usuario> consultarUsuarioNome(@PathVariable String nome) {
		
	
			return this.usuarioService.findByName(nome);

			
	}

	@RequestMapping(value = "/excluir/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody ResponseModel excluir(@PathVariable int id) {
		try {

			this.usuarioService.deleteById(id);

			return new ResponseModel(1, "Registro Exclu�do com sucesso!");

		} catch (Exception e) {

			return new ResponseModel(0, e.getMessage());
		}

	}
		
	

	@RequestMapping(value = "/consultar/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody Usuario buscar(@PathVariable("id") int id) {

		return this.usuarioService.getOne(id);
	}

	@RequestMapping(value = "/autenticarUsuario", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody Usuario buscar(@RequestBody Usuario usuario) {
		matricula = usuario.getMatricula();
		senha = usuario.getSenha();

		return this.usuarioService.autenticarUsuario(matricula, senha);
	}

}