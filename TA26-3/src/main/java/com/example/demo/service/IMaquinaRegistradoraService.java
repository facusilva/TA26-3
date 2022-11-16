package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.MaquinaRegistradora;

public interface IMaquinaRegistradoraService {

	//Métodos del CRUD
	public List<MaquinaRegistradora> listarMaquinaRegistradoras(); //Listar All
	
	public MaquinaRegistradora guardarMaquinaRegistradora(MaquinaRegistradora MaquinaRegistradora); //Guarda un MaquinaRegistradora CREATE
	
	public MaquinaRegistradora MaquinaRegistradoraXID(Long id); //Leer datos de un MaquinaRegistradora READ
	
	public MaquinaRegistradora actualizarMaquinaRegistradora(MaquinaRegistradora MaquinaRegistradora); //Actualiza datos del MaquinaRegistradora UPDATE
	
	public void eliminarMaquinaRegistradora(Long id);//Elimina el MaquinaRegistradora DELETE
}
