package com.example.demo.controller;

import java.util.List;
import com.example.demo.dto.Cajero;
import com.example.demo.service.CajeroServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CajeroController {

	@Autowired
	CajeroServiceImpl CajeroServiceImpl;
	
	//listar todos los Cajeros
	@GetMapping("/cajeros")
	public List<Cajero> listarCajeros(){
		return CajeroServiceImpl.listarCajeros();
	}
	
	//guardar un Cajero
	@PostMapping("/cajeros")
	public Cajero salvarCajero(@RequestBody Cajero Cajero) {//los datos del Cajero llegan en formato JSON desde el Request Body
		return CajeroServiceImpl.guardarCajero(Cajero);
	}
	
	//muestro un Cajero según el ID indicada
	@GetMapping("/cajeros/{id}") 
	public Cajero CajeroXID(@PathVariable(name="id") Long id){ // el id del Cajero llega desde la variable del path
		Cajero Cajero_xid = new Cajero();//creo una instancia de la clase Cajero
		
		Cajero_xid=CajeroServiceImpl.CajeroXID(id);//busco el Cajero según el ID y le asigno los datos a la instancia de la clase Cajero
		
		System.out.println("Cajero XID: "+Cajero_xid);
		
		return Cajero_xid;//devuelvo el Cajero en formato JSON
	}
	
	//Actualizo los datos de un Cajero según el ID indicada
	@PutMapping("/cajeros/{id}")
	public Cajero actualizarCajero(@PathVariable(name="id")Long id,@RequestBody Cajero Cajero) {
		
		Cajero Cajero_seleccionado= new Cajero();
		Cajero Cajero_actualizado= new Cajero();
		
		Cajero_seleccionado= CajeroServiceImpl.CajeroXID(id);
		
		Cajero_seleccionado.setNomApels(Cajero.getNomApels());
		Cajero_seleccionado.setVentas(Cajero.getVentas());
		
		Cajero_actualizado = CajeroServiceImpl.actualizarCajero(Cajero_seleccionado);
		
		System.out.println("El Cajero actualizado es: "+ Cajero_actualizado);
		
		return Cajero_actualizado;
	}
	
	//borro el Cajero indicado por el ID que llega en la variable del path
	@DeleteMapping("/cajeros/{id}")
	public void eleiminarCajero(@PathVariable(name="id")Long id) {
		CajeroServiceImpl.eliminarCajero(id);
	}
}
