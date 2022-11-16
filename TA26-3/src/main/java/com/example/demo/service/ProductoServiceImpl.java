package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IProductoDAO;
import com.example.demo.dto.Producto;

@Service 
public class ProductoServiceImpl implements IProductoService{

	@Autowired
	IProductoDAO iProductoDAO;
	
	@Override
	public List<Producto> listarProductos() {
		// TODO Auto-generated method stub
		return iProductoDAO.findAll();
	}

	@Override
	public Producto guardarProducto(Producto Producto) {
		// TODO Auto-generated method stub
			return iProductoDAO.save(Producto); //guardo el nuevo Producto	
	}

	@Override
	public Producto ProductoXID(Long id) {
		// TODO Auto-generated method stub
		return iProductoDAO.findById(id).get();
	}

	@Override
	public Producto actualizarProducto(Producto Producto) {
		// TODO Auto-generated method stub
		return iProductoDAO.save(Producto);
	}

	@Override
	public void eliminarProducto(Long id) {
		iProductoDAO.deleteById(id);
		
	}

}
