package br.com.tecdainfor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import br.com.tecdainfor.dao.ImpressoraDAO;
import br.com.tecdainfor.dao.SetorDAO;
import br.com.tecdainfor.model.Impressora;
import br.com.tecdainfor.model.Setor;

@Controller
@RequestMapping("/impressora")
public class ImpressoraController {
	
	

	/*
	SetorDAO setordao;

	ImpressoraDAO impressoradao;
	
	
	

	//Recebimento e tratamento dos dados via HTTP.
	
	@RequestMapping(value = "/lista", method= RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody List<Impressora> ConsultarTodos(){
		return 	this.impressoradao.listarImpressoras();
	}
	
	@RequestMapping(value = "/listasetor", method= RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody List<Setor> ConsultarSetor(){
		return 	this.setordao.listarSetores();
	}
	
	@RequestMapping(value = "/cadastrar", method = RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody Impressora salvar(@RequestBody Impressora impressora) {
		return this.impressoradao.cadastrarImpressora(impressora);				
	}
	
	@RequestMapping(value = "/alterar", method = RequestMethod.PUT, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody Impressora editar(@RequestBody Impressora impressora){
		impressoradao.alterarImpressora(impressora);
		return impressora;
	}
	
	@RequestMapping (value = "/buscar/{nome}", method= RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody List<Impressora> consultarImpressoraNome(@PathVariable String nome){
		return this.impressoradao.listarImpSetor(nome);
	}
	
	@RequestMapping (value = "/excluir/{id}", method = RequestMethod.DELETE,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody Impressora excluir(@PathVariable int id){
		return this.impressoradao.excluir(id);
	}
	*/
}
