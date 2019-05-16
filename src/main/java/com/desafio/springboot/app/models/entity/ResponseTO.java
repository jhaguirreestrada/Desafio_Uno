package com.desafio.springboot.app.models.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResponseTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@JsonProperty("id")
	private Long id;  
	
	@JsonProperty("fechaCreacion")
	private LocalDate fechaCreacion;
	
	@JsonProperty("fechaFin")
	private LocalDate fechaFin;
	
	@JsonProperty("fechas")
	@Valid
	private List<LocalDate> fechas;
	
	@JsonProperty("fechasFaltantes")	
	private List<LocalDate> fechasFaltantes;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(LocalDate fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public LocalDate getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(LocalDate fechaFin) {
		this.fechaFin = fechaFin;
	}

	public List<LocalDate> getFechas() {
		return fechas;
	}

	public void setFechas(List<LocalDate> fechas) {
		this.fechas = fechas;
	}

	public List<LocalDate> getFechasFaltantes() {
		return fechasFaltantes;
	}

	public void setFechasFaltantes(List<LocalDate> fechasFaltantes) {
		this.fechasFaltantes = fechasFaltantes;
	}
	
	
}
