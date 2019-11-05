package pe.upn.embarcadero.model.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;



@Entity
@Table(name = "plato")
public class Plato {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "plato_nom", length = 60)
	private String nombre;

	
	@ManyToMany
	@JoinTable(name = "plato_pedido",
	joinColumns = @JoinColumn(columnDefinition = "plato_id"),
	inverseJoinColumns = @JoinColumn(columnDefinition = "id"))
private List<Pedido> pedidos;
	
	public Plato() {
		pedidos = new ArrayList<>();
	}
	
	
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	
	
	

}
