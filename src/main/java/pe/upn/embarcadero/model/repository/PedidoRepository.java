package pe.upn.embarcadero.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.upn.embarcadero.model.entity.Pedido;



@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer> {

}
