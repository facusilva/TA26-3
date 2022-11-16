package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IMaquinaRegistradoraDAO;
import com.example.demo.dto.MaquinaRegistradora;

@Service 
public class MaquinaRegistradoraServiceImpl implements IMaquinaRegistradoraService{

	@Autowired
	IMaquinaRegistradoraDAO iMaquinaRegistradoraDAO;
	
	@Override
	public List<MaquinaRegistradora> listarMaquinaRegistradoras() {
		// TODO Auto-generated method stub
		return iMaquinaRegistradoraDAO.findAll();
	}

	@Override
	public MaquinaRegistradora guardarMaquinaRegistradora(MaquinaRegistradora MaquinaRegistradora) {
		// TODO Auto-generated method stub
			return iMaquinaRegistradoraDAO.save(MaquinaRegistradora); //guardo el nuevo MaquinaRegistradora	
	}

	@Override
	public MaquinaRegistradora MaquinaRegistradoraXID(Long id) {
		// TODO Auto-generated method stub
		return iMaquinaRegistradoraDAO.findById(id).get();
	}

	@Override
	public MaquinaRegistradora actualizarMaquinaRegistradora(MaquinaRegistradora MaquinaRegistradora) {
		// TODO Auto-generated method stub
		return iMaquinaRegistradoraDAO.save(MaquinaRegistradora);
	}

	@Override
	public void eliminarMaquinaRegistradora(Long id) {
		iMaquinaRegistradoraDAO.deleteById(id);
		
	}

}
