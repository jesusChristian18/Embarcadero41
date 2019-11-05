package pe.upn.embarcadero.model.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="camarero")
public class Camarero {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "camarero_nom", length = 60)
	private String nombre;

	
	
	@OneToMany(mappedBy = "camarero", fetch = FetchType.LAZY)
	private List<Pedido> pedidos;
	
	public Camarero() {
		pedidos = new ArrayList<>();
	}
	
	public void addPedido( Pedido pedido) {
		
		this.pedidos.add(pedido);
	}
	
	
	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
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
