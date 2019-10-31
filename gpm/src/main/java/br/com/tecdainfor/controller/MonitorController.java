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

import br.com.tecdainfor.dao.MonitorDAO;
import br.com.tecdainfor.dao.SetorDAO;
import br.com.tecdainfor.model.Monitor;
import br.com.tecdainfor.model.Setor;


@Controller
@RequestMapping("/monitor")
public class MonitorController {

	
/*	SetorDAO setordao;
	
	MonitorDAO monitordao;
	

	
	//Recebimento e tratamento dos dados via HTTP.
	
	@RequestMapping(value = "/lista", method= RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody List<Monitor> ConsultarTodos(){
		return 	this.monitordao.listarMonitores();
	}
	
	@RequestMapping(value = "/listasetor", method= RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody List<Setor> ConsultarSetor(){
		return 	this.setordao.listarSetores();
	}
	
	@RequestMapping(value = "/cadastrar", method = RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody Monitor salvar(@RequestBody Monitor monitor) {
		return this.monitordao.cadastrarMonitor(monitor);				
	}
	
	@RequestMapping(value = "/alterar", method = RequestMethod.PUT, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody Monitor editar(@RequestBody Monitor monitor){
		monitordao.alterarMonitor(monitor);
		return monitor;
	}
	
	@RequestMapping (value = "/buscar/{nome}", method= RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody List<Monitor> consultarMonitorTomb(@PathVariable String nome){
		return this.monitordao.consultarMonitorTomb(nome);
	}
	
	@RequestMapping (value = "/excluir/{id}", method = RequestMethod.DELETE,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody Monitor excluir(@PathVariable int id){
		return this.monitordao.excluir(id);
	}

	*/
}
