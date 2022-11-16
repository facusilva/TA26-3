package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IVentaDAO;
import com.example.demo.dto.Venta;

@Service 
public class VentaServiceImpl implements IVentaService{

	@Autowired
	IVentaDAO iVentaDAO;
	
	@Override
	public List<Venta> listarVentas() {
		// TODO Auto-generated method stub
		return iVentaDAO.findAll();
	}

	@Override
	public Venta guardarVenta(Venta Venta) {
		// TODO Auto-generated method stub
			return iVentaDAO.save(Venta); //guardo el nuevo Venta	
	}

	@Override
	public Venta VentaXID(Long id) {
		// TODO Auto-generated method stub
		return iVentaDAO.findById(id).get();
	}

	@Override
	public Venta actualizarVenta(Venta Venta) {
		// TODO Auto-generated method stub
		return iVentaDAO.save(Venta);
	}

	@Override
	public void eliminarVenta(Long id) {
		iVentaDAO.deleteById(id);
		
	}

}
