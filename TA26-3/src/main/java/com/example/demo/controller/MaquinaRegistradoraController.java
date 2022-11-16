package com.example.demo.controller;

import java.util.List;
import com.example.demo.dto.MaquinaRegistradora;
import com.example.demo.service.MaquinaRegistradoraServiceImpl;

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
public class MaquinaRegistradoraController {

	@Autowired
	MaquinaRegistradoraServiceImpl MaquinaRegistradoraServiceImpl;
	
	//listar todos los MaquinaRegistradoras
	@GetMapping("/maquinas")
	public List<MaquinaRegistradora> listarMaquinaRegistradoras(){
		return MaquinaRegistradoraServiceImpl.listarMaquinaRegistradoras();
	}
	
	//guardar un MaquinaRegistradora
	@PostMapping("/maquinas")
	public MaquinaRegistradora salvarMaquinaRegistradora(@RequestBody MaquinaRegistradora MaquinaRegistradora) {//los datos del MaquinaRegistradora llegan en formato JSON desde el Request Body
		return MaquinaRegistradoraServiceImpl.guardarMaquinaRegistradora(MaquinaRegistradora);
	}
	
	//muestro un MaquinaRegistradora según el ID indicada
	@GetMapping("/maquinas/{id}") 
	public MaquinaRegistradora MaquinaRegistradoraXID(@PathVariable(name="id") Long id){ // el id del MaquinaRegistradora llega desde la variable del path
		MaquinaRegistradora MaquinaRegistradora_xid = new MaquinaRegistradora();//creo una instancia de la clase MaquinaRegistradora
		
		MaquinaRegistradora_xid=MaquinaRegistradoraServiceImpl.MaquinaRegistradoraXID(id);//busco el MaquinaRegistradora según el ID y le asigno los datos a la instancia de la clase MaquinaRegistradora
		
		System.out.println("MaquinaRegistradora XID: "+MaquinaRegistradora_xid);
		
		return MaquinaRegistradora_xid;//devuelvo el MaquinaRegistradora en formato JSON
	}
	
	//Actualizo los datos de un MaquinaRegistradora según el ID indicada
	@PutMapping("/maquinas/{id}")
	public MaquinaRegistradora actualizarMaquinaRegistradora(@PathVariable(name="id")Long id,@RequestBody MaquinaRegistradora MaquinaRegistradora) {
		
		MaquinaRegistradora MaquinaRegistradora_seleccionado= new MaquinaRegistradora();
		MaquinaRegistradora MaquinaRegistradora_actualizado= new MaquinaRegistradora();
		
		MaquinaRegistradora_seleccionado= MaquinaRegistradoraServiceImpl.MaquinaRegistradoraXID(id);
		
		MaquinaRegistradora_seleccionado.setPiso(MaquinaRegistradora.getPiso());
		MaquinaRegistradora_seleccionado.setVentas(MaquinaRegistradora.getVentas());
		
		MaquinaRegistradora_actualizado = MaquinaRegistradoraServiceImpl.actualizarMaquinaRegistradora(MaquinaRegistradora_seleccionado);
		
		System.out.println("El MaquinaRegistradora actualizado es: "+ MaquinaRegistradora_actualizado);
		
		return MaquinaRegistradora_actualizado;
	}
	
	//borro el MaquinaRegistradora indicado por el ID que llega en la variable del path
	@DeleteMapping("/maquinas/{id}")
	public void eleiminarMaquinaRegistradora(@PathVariable(name="id")Long id) {
		MaquinaRegistradoraServiceImpl.eliminarMaquinaRegistradora(id);
	}
}
