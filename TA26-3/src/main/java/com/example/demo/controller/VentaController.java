package com.example.demo.controller;

import java.util.List;
import com.example.demo.dto.Venta;
import com.example.demo.service.VentaServiceImpl;

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
public class VentaController {

	@Autowired
	VentaServiceImpl VentaServiceImpl;
	
	//listar todos los Ventas
	@GetMapping("/ventas")
	public List<Venta> listarVentas(){
		return VentaServiceImpl.listarVentas();
	}
	
	//guardar un Venta
	@PostMapping("/ventas")
	public Venta salvarVenta(@RequestBody Venta Venta) {//los datos del Venta llegan en formato JSON desde el Request Body
		return VentaServiceImpl.guardarVenta(Venta);
	}
	
	//muestro un Venta según el ID indicada
	@GetMapping("/ventas/{id}") 
	public Venta VentaXID(@PathVariable(name="id") Long id){ // el id del Venta llega desde la variable del path
		Venta Venta_xid = new Venta();//creo una instancia de la clase Venta
		
		Venta_xid=VentaServiceImpl.VentaXID(id);//busco el Venta según el ID y le asigno los datos a la instancia de la clase Venta
		
		System.out.println("Venta XID: "+Venta_xid);
		
		return Venta_xid;//devuelvo el Venta en formato JSON
	}
	
	//Actualizo los datos de un Venta según el ID indicada
	@PutMapping("/ventas/{id}")
	public Venta actualizarVenta(@PathVariable(name="id")Long id,@RequestBody Venta Venta) {
		
		Venta Venta_seleccionado= new Venta();
		Venta Venta_actualizado= new Venta();
		
		Venta_seleccionado= VentaServiceImpl.VentaXID(id);
		
		Venta_seleccionado.setCajero(Venta.getCajero());
		Venta_seleccionado.setMaquina(Venta.getMaquina());
		Venta_seleccionado.setProducto(Venta.getProducto());
		
		Venta_actualizado = VentaServiceImpl.actualizarVenta(Venta_seleccionado);
		
		System.out.println("El Venta actualizado es: "+ Venta_actualizado);
		
		return Venta_actualizado;
	}
	
	//borro el Venta indicado por el ID que llega en la variable del path
	@DeleteMapping("/ventas/{id}")
	public void eleiminarVenta(@PathVariable(name="id")Long id) {
		VentaServiceImpl.eliminarVenta(id);
	}
}
