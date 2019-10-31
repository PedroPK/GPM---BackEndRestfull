package br.com.tecdainfor.controller;

import java.util.List;

import javax.swing.JOptionPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import br.com.tecdainfor.dao.UsuarioDAO;
import br.com.tecdainfor.dao.UsuarioJpaRepository;
import br.com.tecdainfor.model.Computador;
import br.com.tecdainfor.model.ResponseModel;
import br.com.tecdainfor.model.Usuario;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	UsuarioDAO usuariodao;
	private int matricula;
	private String senha;
	@Autowired
	private UsuarioJpaRepository repository;
	
	

 

	// Recebimento e tratamento dos dados via HTTP.

	@RequestMapping(value = "/lista", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody List<Usuario> ConsultarTodos() {
		return this.repository.findAll();
	}

	@RequestMapping(value = "/cadastrar", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody ResponseModel salvar(@RequestBody Usuario usuario) {

		try {

			this.repository.save(usuario);

			return new ResponseModel(1, "Registro salvo com sucesso!");

		} catch (Exception e) {

			return new ResponseModel(0, e.getMessage());
		}

	}

	@RequestMapping(value = "/alterar", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody ResponseModel editar(@RequestBody Usuario usuario) {
		
		try {

			this.repository.save(usuario);

			return new ResponseModel(1, "Registro Atualizado com sucesso!");

		} catch (Exception e) {

			return new ResponseModel(0, e.getMessage());
		}

	}
		
	

	@RequestMapping(value = "/buscar/{nome}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody List<Usuario> consultarUsuarioNome(@PathVariable String nome) {
		
	
			return this.repository.findByName(nome);

			
	}

	@RequestMapping(value = "/excluir/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody ResponseModel excluir(@PathVariable Long id) {
		try {

			this.repository.deleteById(id);

			return new ResponseModel(1, "Registro Excluído com sucesso!");

		} catch (Exception e) {

			return new ResponseModel(0, e.getMessage());
		}

	}
		
	

	@RequestMapping(value = "/consultar/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody Usuario buscar(@PathVariable("id") Long id) {

		return this.repository.getOne(id);
	}

	@RequestMapping(value = "/autenticarUsuario", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody Usuario buscar(@RequestBody Usuario usuario) {
		matricula = usuario.getMatricula();
		senha = usuario.getSenha();

		return this.repository.autenticarUsuario(matricula, senha);
	}

}