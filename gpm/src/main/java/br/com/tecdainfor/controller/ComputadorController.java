package br.com.tecdainfor.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import br.com.tecdainfor.dao.ComputadorDAO;
import br.com.tecdainfor.model.Computador;


@CrossOrigin(origins  = "http://localhost:4200")
@RestController
@RequestMapping("/computador")
public class ComputadorController {
	
	
	@Autowired
	ComputadorDAO computadordao;
	
	//Recebimento e tratamento dos dados via HTTP.
	
	
	@RequestMapping(value = "/listar", method= RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody List<Computador> ConsultarTodos(){
		List<Computador> lista = this.computadordao.listarComputadores();
				return 	lista;
	}
	
	/*@RequestMapping(value = "/listasetor", method= RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody List<Setor> ListaSetor(){
		return 	this.computadordao.listaSetor();
	}*/
	
		
	@RequestMapping(value = "/cadastrar", method = RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody  Computador salvar(@RequestBody Computador computador) {
		return this.computadordao.cadastrarComputador(computador);				
	}
	
	@RequestMapping(value = "/editar", method = RequestMethod.PUT, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody Computador editar(@RequestBody Computador computador){
		computadordao.alterarComputador(computador);
		return computador;
	}
	
	@RequestMapping (value = "/listarporsetor/{setor}", method= RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody List<Computador> listaCompSetor(@PathVariable String setor){
		List<Computador> computador = computadordao.listaCompSetor(setor);
		return computador;
		

	}
	
	@RequestMapping (value = "/consultar/{id}",method= RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody Computador consultarComputador(@PathVariable int id) {
		return this.computadordao.consultarComputador(id);
	}
	
	@RequestMapping (value = "/excluir/{id}",method = RequestMethod.DELETE,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody Computador excluir(@PathVariable int id){
		return this.computadordao.excluir(id);
	}

}
