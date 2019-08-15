package br.com.tecdainfor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("*")
public class IndexController {
	
	@RequestMapping("*")
	public String index(){
		return "index";
	}
	
	@RequestMapping("painel")
		public String painel(){
			return "painel";
		}

}
