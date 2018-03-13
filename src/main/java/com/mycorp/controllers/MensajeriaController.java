package com.mycorp.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mycorp.models.CorreoElectronico;
import com.mycorp.services.MensajeriaService;

@RestController
public class MensajeriaController {

	@Autowired
    private MensajeriaService mensajeriaService; 
	
	CorreoElectronico correoElectronico;
	
	/** Metodo que envía un correo y mustra que se ha enviado con éxito en el navegador
	 * 
	 * @return String
	 */
	@RequestMapping("/enviarCorreo")
	public String enviarCorreo(){
		try{
			correoElectronico = new CorreoElectronico(1L,"Español");
			correoElectronico.setTexto("Este Correo contiene valores correctos");
			mensajeriaService.enviar(correoElectronico);
			
			return "<div style=\"width:100%;text-align:center;margin-top:20px;\">"
				+ "<a style=\"color:green;\">Correo enviado correctamente</a></br>"
				+ "<a>Idioma: "+correoElectronico.getIdioma() +"</a></br>"
			    + "<a>Texto: "+correoElectronico.getTexto() +"</a></br>"
			    + "<a>Fecha: "+new Date() +"</a></br>"
			   + "</div>";
		
		}catch(Exception e ){
			return e.getMessage();
		}
	}
	
	/** Metodo que produce un error y muestra dicho error en el navegador
	 * 
	 * @return String
	 */
	@RequestMapping("/enviarCorreoError")
	public String enviarCorreoError(){
		try{
			correoElectronico = new CorreoElectronico(1L,"Español");
			correoElectronico.setTexto("Este Correo contiene valores erróneos");
			mensajeriaService.enviar(correoElectronico);
			Date date = new SimpleDateFormat().parse("Errorrr");
			return date.toString();
		
		}catch(Exception e ){
			return "<div style=\"width:100%;text-align:center;margin-top:20px;\">"
					+ "<a style=\"color:red;\">El correo no se pudo enviar</a></br>"
					+ "<a>Idioma: "+correoElectronico.getIdioma() +"</a></br>"
				    + "<a>Texto: "+correoElectronico.getTexto() +"</a></br>"
				    + "<a>Fecha: "+new Date() +"</a></br>"
				   + "</div>";
		}
	}
}
