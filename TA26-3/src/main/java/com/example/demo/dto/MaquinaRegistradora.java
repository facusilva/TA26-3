package com.example.demo.dto;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="maquinas_registradoras")
public class MaquinaRegistradora {

	//atributos de la entidad
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codigo")
	private Long id;
	private int piso;
	
	@OneToMany
	@JoinColumn(name="maquina")
	private List<Venta> ventas;
	
	//constructores
	
	public MaquinaRegistradora() {
		
	}
	
	
	public MaquinaRegistradora(Long id, int piso) {
		this.id = id;
		this.piso = piso;
	}


	//getters y setters
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public int getPiso() {
		return piso;
	}


	public void setPiso(int piso) {
		this.piso = piso;
	}
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "maquina")
	public List<Venta> getVentas() {
		return ventas;
	}

	public void setVentas(List<Venta> ventas) {
		this.ventas = ventas;
	}


	@Override
	public String toString() {
		return "MaquinaRegistradora [id=" + id + ", piso=" + piso + "]";
	}

	
	
	
	
	
	
}
