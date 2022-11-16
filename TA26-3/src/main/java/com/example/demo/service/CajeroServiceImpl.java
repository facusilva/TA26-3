package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ICajeroDAO;
import com.example.demo.dto.Cajero;

@Service 
public class CajeroServiceImpl implements ICajeroService{

	@Autowired
	ICajeroDAO iCajeroDAO;
	
	@Override
	public List<Cajero> listarCajeros() {
		// TODO Auto-generated method stub
		return iCajeroDAO.findAll();
	}

	@Override
	public Cajero guardarCajero(Cajero Cajero) {
		// TODO Auto-generated method stub
			return iCajeroDAO.save(Cajero); //guardo el nuevo Cajero	
	}

	@Override
	public Cajero CajeroXID(Long id) {
		// TODO Auto-generated method stub
		return iCajeroDAO.findById(id).get();
	}

	@Override
	public Cajero actualizarCajero(Cajero Cajero) {
		// TODO Auto-generated method stub
		return iCajeroDAO.save(Cajero);
	}

	@Override
	public void eliminarCajero(Long id) {
		iCajeroDAO.deleteById(id);
		
	}

}
