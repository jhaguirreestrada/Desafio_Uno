package com.desafio.springboot.app.controllers;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.desafio.springboot.app.models.entity.Dato;
import com.desafio.springboot.app.models.entity.ResponseTO;
import com.desafio.springboot.app.models.service.Procesa;

import ch.qos.logback.core.net.server.Client;

@Controller
@RequestMapping("/")
public class IndexController {	
	
	private Procesa procesa= new Procesa();
	
	@RequestMapping(value="/procesaGDD",method=RequestMethod.POST, headers = "Accept=application/json")
    public  ResponseTO procesaGDD(HttpServletResponse httpResponse ) 
    {    
        ResponseTO response = new ResponseTO();

        Client client = (Client) ClientBuilder.newClient();
		WebTarget target = ((javax.ws.rs.client.Client) client).target("http://localhost:8080/gdd"); //se asume la url del servicio rest
		Dato request = target.request("application/json").get(Dato.class);

		response = procesa.ProcesaFechas(request);
		return response;

    }    
			
}