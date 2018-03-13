package com.mycorp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mycorp.services.ZendeskService;

import util.datos.UsuarioAlta;

@RestController
public class ZendeskController {

	@Autowired
    private ZendeskService zendeskService;
	
	UsuarioAlta usuarioAlta= new UsuarioAlta();
	
	@RequestMapping("/")
    public String serverRunning() {
		return "Spring boot running...";
	}
	
	@RequestMapping(value="/alta/{agente}", method = RequestMethod.GET)
	public @ResponseBody String altaTicketZendesk(@PathVariable("agente") String userAgent){
		
		try{
			zendeskService.altaTicketZendesk(usuarioAlta, userAgent);
			return "<div style=\"width:100%;text-align:center;color:green;margin-top:20px;\">"
					+ userAgent +"ha dado de alta un usuario</div>";
		}catch(Exception e){
			return "<div style=\"width:100%;text-align:center;margin-top:20px;\">"
					+"<h2>"+ userAgent +" no ha podido dar de alta un usuario</h2></br>"+
					"<a style=\"color:red;\">ERROR: "+e.getMessage()+"</a></div>";
		}
	}
}
