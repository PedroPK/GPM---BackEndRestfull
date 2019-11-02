package br.com.tecdainfor.controller;

import java.util.List;
import java.util.Optional;

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
import br.com.tecdainfor.dao.UsuarioDAO;
import br.com.tecdainfor.model.Computador;
import br.com.tecdainfor.model.ResponseModel;
import br.com.tecdainfor.model.Setor;
import br.com.tecdainfor.model.Usuario;
import br.com.tecdainfor.service.SetorService;
import br.com.tecdainfor.service.UsuarioService;

@CrossOrigin
@RestController
@RequestMapping("/setor")
public class SetorController {
	
	
	@Autowired
	private SetorService setorservice;
	@Autowired
	private UsuarioService usuarioservice;
	
	
	
	//Recebimento e tratamento dos dados via HTTP.
	
    
	@RequestMapping(value = "/listar", method= RequestMethod.GET)
	public @ResponseBody List<Setor> ConsultarTodos(){
		return 	this.setorservice.listarSetores();
	}
	
	
	@RequestMapping(value = "/cadastrar", method = RequestMethod.POST)
	public @ResponseBody ResponseModel salvar(@RequestBody Setor setor1) {
		      
		   int iduser = setor1.getChefeSetorIdRef();
	       Usuario user = new Usuario();
	       user = usuarioservice.getOne(iduser);
	       Setor setor2 = new Setor();
	       setor2 = setor1;
	       setor2.setChefedosetor(user);
		

		try {
            
			this.setorservice.cadastrarSetor(setor2);	
 
			return new ResponseModel(1,"Registro salvo com sucesso!");
 
		}catch(Exception e) {
 
			return new ResponseModel(0,e.getMessage());			
		}
	}
				
	
	
	 
	@RequestMapping(value = "/alterar", method = RequestMethod.PUT)
	public @ResponseBody ResponseModel editar(@RequestBody Setor setor1){
		
		 int iduser = setor1.getChefeSetorIdRef();
	       Usuario user = new Usuario();
	       user = usuarioservice.getOne(iduser);
	       Setor setor2 = new Setor();
	       setor2 = setor1;
	       setor2.setChefedosetor(user);
		
		
		try {
            
			this.setorservice.alterarSetor(setor2);	
 
			return new ResponseModel(1,"Registro alterado com sucesso!");
 
		}catch(Exception e) {
 
			return new ResponseModel(0,e.getMessage());			
		}
	}
		
		
	
	 
	@RequestMapping (value = "/excluir/{id}", method = RequestMethod.DELETE)
	public @ResponseBody ResponseModel excluir(@PathVariable int id){
		

		try {
            
			this.setorservice.excluir(id);
 
			return new ResponseModel(1,"Registro excluído com sucesso!");
 
		}catch(Exception e) {
 
			return new ResponseModel(0,e.getMessage());			
		}
	}


   @RequestMapping(value="/consultar/{id}", method = RequestMethod.GET)
   public @ResponseBody Setor buscar(@PathVariable("id") int id){

	return this.setorservice.consultarSetor(id);
}
}