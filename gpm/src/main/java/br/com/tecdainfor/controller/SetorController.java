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



import br.com.tecdainfor.dao.SetorDAO;
import br.com.tecdainfor.model.Computador;
import br.com.tecdainfor.model.Setor;



@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/setor")
public class SetorController {
	
	
	@Autowired
	SetorDAO setordao;
	
	
	
	//Recebimento e tratamento dos dados via HTTP.
	
    
	@RequestMapping(value = "/listar", method= RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody List<Setor> ConsultarTodos(){
		return 	this.setordao.listarSetores();
	}
	
	
	@RequestMapping(value = "/cadastrar", method = RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody Setor salvar(@RequestBody Setor setor) {
		return this.setordao.cadastrarSetor(setor);				
	}
	
	 
	@RequestMapping(value = "/alterar", method = RequestMethod.PUT, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody Setor editar(@RequestBody Setor setor){
		setordao.alterarSetor(setor);
		return setor;
	}
	
	 
	@RequestMapping (value = "/excluir/{id}", method = RequestMethod.DELETE,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody Setor excluir(@PathVariable int id){
		return this.setordao.excluir(id);
	}


   @RequestMapping(value="/consultar/{id}", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
   public @ResponseBody Setor buscar(@PathVariable("id") Integer id){

	return this.setordao.consultarSetor(id);
}
}