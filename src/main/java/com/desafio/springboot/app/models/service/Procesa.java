package com.desafio.springboot.app.models.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import com.desafio.springboot.app.models.entity.Dato;
import com.desafio.springboot.app.models.entity.ResponseTO;

public class Procesa {
@SuppressWarnings("rawtypes")
private HashMap ObtenFechas(Dato datoRequest) {
		
		Map<Integer,LocalDate> fechasMap = new HashMap<Integer,LocalDate>();
		
		List<LocalDate> fechas = new ArrayList<LocalDate>();
		fechas = datoRequest.getFechas();
		int i = 0;

		if(fechas.size() < 100){ //se valida que las fechas esten imcompletas, caso contrario se retorna vacio en el map		
			for (LocalDate fecha : fechas) {
			 	fechasMap.put(i, fecha);
			 	i++;
			}
		}

		return (HashMap) fechasMap;
	}
	
	@SuppressWarnings("unchecked")
	public ResponseTO ProcesaFechas(Dato datoRequest) {
		ResponseTO datoResponse = new ResponseTO();
	    datoResponse.setId(datoRequest.getId());
	    datoResponse.setFechaCreacion(datoRequest.getFechaCreacion());
	    datoResponse.setFechaFin(datoRequest.getFechaCreacion());
	          
	    Map<Integer,LocalDate> fechasMap = new HashMap<Integer,LocalDate>();
	    fechasMap = ObtenFechas(datoRequest);  //obtenemos las fechas existentes al map
	
	    List<LocalDate> fechasExistentes =new ArrayList<LocalDate>();              	
		Set<LocalDate> fechasFaltantes = new HashSet();        
	
		//recorremos desde la fecha inicio hasta la fecha fin
		LocalDate fechaInicio = datoResponse.getFechaCreacion();
		LocalDate fechaFin = datoResponse.getFechaFin();
	
		while (fechaInicio.isBefore(fechaFin)) {    
			//evaluo si la fecha existe en el map sino la agrego
			if(!fechasMap.isEmpty() && !fechasMap.containsValue(fechaInicio))
			{
				fechasFaltantes.add(fechaInicio);
			}else{
				fechasExistentes.add(fechaInicio);
			}
	
			fechaInicio = fechaInicio.plusMonths(1);
		}
	
	
		datoResponse.setFechas(fechasExistentes);
	
		datoResponse.setFechasFaltantes(fechasFaltantes.stream()
	        .sorted()
	        .collect(Collectors.toList()));
		    	
		return datoResponse;
	}		

}
