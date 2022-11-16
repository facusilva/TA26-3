package com.example.demo.dto;

import javax.persistence.*;

@Entity
@Table(name="ventas")
public class Venta {

	//atributos de la entidad
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="cajero")
	private Cajero cajero;

	@ManyToOne
	@JoinColumn(name="maquina")
	private MaquinaRegistradora maquina;
	
	@ManyToOne
	@JoinColumn(name="producto")
	private Producto producto;
	
	//constructores

	public Venta() {
	}


	public Venta(Long id, Cajero cajero, MaquinaRegistradora maquina, Producto producto) {
		this.id = id;
		this.cajero = cajero;
		this.maquina = maquina;
		this.producto = producto;
	}


	//getters y setters
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Cajero getCajero() {
		return cajero;
	}


	public void setCajero(Cajero cajero) {
		this.cajero = cajero;
	}


	public MaquinaRegistradora getMaquina() {
		return maquina;
	}


	public void setMaquina(MaquinaRegistradora maquina) {
		this.maquina = maquina;
	}


	public Producto getProducto() {
		return producto;
	}


	public void setProducto(Producto producto) {
		this.producto = producto;
	}


	@Override
	public String toString() {
		return "Venta [id=" + id + ", cajero=" + cajero + ", maquina=" + maquina + ", producto=" + producto + "]";
	}

	

	

}
