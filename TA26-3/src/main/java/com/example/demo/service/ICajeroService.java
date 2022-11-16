package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Cajero;

public interface ICajeroService {

	//Métodos del CRUD
	public List<Cajero> listarCajeros(); //Listar All
	
	public Cajero guardarCajero(Cajero Cajero); //Guarda un Cajero CREATE
	
	public Cajero CajeroXID(Long id); //Leer datos de un Cajero READ
	
	public Cajero actualizarCajero(Cajero Cajero); //Actualiza datos del Cajero UPDATE
	
	public void eliminarCajero(Long id);//Elimina el Cajero DELETE
}
