package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Producto;

public interface IProductoService {

	//Métodos del CRUD
	public List<Producto> listarProductos(); //Listar All
	
	public Producto guardarProducto(Producto Producto); //Guarda un Producto CREATE
	
	public Producto ProductoXID(Long id); //Leer datos de un Producto READ
	
	public Producto actualizarProducto(Producto Producto); //Actualiza datos del Producto UPDATE
	
	public void eliminarProducto(Long id);//Elimina el Producto DELETE
}
