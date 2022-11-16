package com.example.demo.controller;

import java.util.List;
import com.example.demo.dto.Producto;
import com.example.demo.service.ProductoServiceImpl;

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
public class ProductoController {

	@Autowired
	ProductoServiceImpl ProductoServiceImpl;
	
	//listar todos los Productos
	@GetMapping("/productos")
	public List<Producto> listarProductos(){
		return ProductoServiceImpl.listarProductos();
	}
	
	//guardar un Producto
	@PostMapping("/productos")
	public Producto salvarProducto(@RequestBody Producto Producto) {//los datos del Producto llegan en formato JSON desde el Request Body
		return ProductoServiceImpl.guardarProducto(Producto);
	}
	
	//muestro un Producto según el ID indicada
	@GetMapping("/productos/{id}") 
	public Producto ProductoXID(@PathVariable(name="id") Long id){ // el id del Producto llega desde la variable del path
		Producto Producto_xid = new Producto();//creo una instancia de la clase Producto
		
		Producto_xid=ProductoServiceImpl.ProductoXID(id);//busco el Producto según el ID y le asigno los datos a la instancia de la clase Producto
		
		System.out.println("Producto XID: "+Producto_xid);
		
		return Producto_xid;//devuelvo el Producto en formato JSON
	}
	
	//Actualizo los datos de un Producto según el ID indicada
	@PutMapping("/productos/{id}")
	public Producto actualizarProducto(@PathVariable(name="id")Long id,@RequestBody Producto Producto) {
		
		Producto Producto_seleccionado= new Producto();
		Producto Producto_actualizado= new Producto();
		
		Producto_seleccionado= ProductoServiceImpl.ProductoXID(id);
		
		Producto_seleccionado.setNombre(Producto.getNombre());
		Producto_seleccionado.setPrecio(Producto.getPrecio());
		Producto_seleccionado.setVentas(Producto.getVentas());
		
		Producto_actualizado = ProductoServiceImpl.actualizarProducto(Producto_seleccionado);
		
		System.out.println("El Producto actualizado es: "+ Producto_actualizado);
		
		return Producto_actualizado;
	}
	
	//borro el Producto indicado por el ID que llega en la variable del path
	@DeleteMapping("/productos/{id}")
	public void eleiminarProducto(@PathVariable(name="id")Long id) {
		ProductoServiceImpl.eliminarProducto(id);
	}
}
