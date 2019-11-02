package br.com.tecdainfor.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import br.com.tecdainfor.dao.ComputadorDAO;
import br.com.tecdainfor.dao.SetorDAO;

import br.com.tecdainfor.model.Computador;
import br.com.tecdainfor.model.ResponseModel;
import br.com.tecdainfor.model.Setor;
import br.com.tecdainfor.service.ComputadorService;


@CrossOrigin
@RestController
@RequestMapping("/computador")
public class ComputadorController {
	
	
	@Autowired
	ComputadorService servico;
	
	
	//Recebimento e tratamento dos dados via HTTP.
	

	@RequestMapping(value = "/listar", method= RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody List<Computador> ConsultarTodos(){
		List<Computador> lista = this.servico.listarComputadores();
				return 	lista;
	}
	
	@RequestMapping(value = "/listarSetores", method= RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody List<Setor> ListaSetor(){
		return 	this.servico.listaSetor();
	}
	
		
	
	
	@RequestMapping(value="/cadastrar", method = RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody ResponseModel salvar(@RequestBody Computador computador1){
        
	       int idsetor = computador1.getIdrefsetor();
	       Setor setor = new Setor();
	       setor = servico.consultarSetor(idsetor);
	       Computador computador2 = new Computador();
	       computador2 = computador1;
	       computador2.setSetor(setor);
	       
 
		try {
            
			this.servico.cadastrarComputador(computador2);
 
			return new ResponseModel(1,"Registro salvo com sucesso!");
 
		}catch(Exception e) {
 
			return new ResponseModel(0,e.getMessage());			
		}
	}
 
	
	@RequestMapping(value="/atualizar", method = RequestMethod.PUT, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody ResponseModel atualizar(@RequestBody Computador computador1){
 
		   int idsetor = computador1.getIdrefsetor();
	       Setor setor = new Setor();
	       setor = servico.consultarSetor(idsetor);
	       Computador computador2 = new Computador();
	       computador2 = computador1;
	       computador2.setSetor(setor);
		
		
		try {
 
			this.servico.cadastrarComputador(computador2);	
 
			return new ResponseModel(1,"Registro atualizado com sucesso!");
 
		}catch(Exception e) {
 
			return new ResponseModel(0,e.getMessage());
		}
	}
 
	@RequestMapping(value="/consultar/{id}", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody Computador buscar(@PathVariable("id") Integer id){
 
		return this.servico.consultarComputador(id);
	}
 
	/***
	 * EXCLUIR UM REGISTRO PELO C�DIGO
	 * @param codigo
	 * @return
	 */
	@RequestMapping(value="/excluir/{codigo}", method = RequestMethod.DELETE, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody ResponseModel excluir(@PathVariable("codigo") int codigo){
 
		 
		try {
 
			servico.excluir(codigo);
 
			return new ResponseModel(1, "Registro excluido com sucesso!");
 
		}catch(Exception e) {
			return new ResponseModel(0, e.getMessage());
		}
	}

}