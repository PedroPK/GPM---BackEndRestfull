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
import br.com.tecdainfor.model.ResponseModel;


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
	
		
	
	@RequestMapping(value="/cadastrar", method = RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody ResponseModel salvar(@RequestBody Computador computador){
 
 
		try {
 
			this.computadordao.cadastrarComputador(computador);
 
			return new ResponseModel(1,"Registro salvo com sucesso!");
 
		}catch(Exception e) {
 
			return new ResponseModel(0,e.getMessage());			
		}
	}
 
	
	@RequestMapping(value="/atualizar", method = RequestMethod.PUT, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody ResponseModel atualizar(@RequestBody Computador computador){
 
		try {
 
			this.computadordao.alterarComputador(computador);	
 
			return new ResponseModel(1,"Registro atualizado com sucesso!");
 
		}catch(Exception e) {
 
			return new ResponseModel(0,e.getMessage());
		}
	}
 
	
	@RequestMapping(value="/consultar/{codigo}", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody Computador buscar(@PathVariable("codigo") Integer codigo){
 
		return this.computadordao.consultarComputador(codigo);
	}
 
	/***
	 * EXCLUIR UM REGISTRO PELO CÓDIGO
	 * @param codigo
	 * @return
	 */
	@RequestMapping(value="/excluir/{codigo}", method = RequestMethod.DELETE, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody ResponseModel excluir(@PathVariable("codigo") Integer codigo){
 
		Computador computador = computadordao.consultarComputador(codigo);
 
		try {
 
			computadordao.excluir(codigo);
 
			return new ResponseModel(1, "Registro excluido com sucesso!");
 
		}catch(Exception e) {
			return new ResponseModel(0, e.getMessage());
		}
	}

}
