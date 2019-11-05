package pe.upn.embarcadero.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.upn.embarcadero.model.entity.Camarero;

@Repository
public interface CamareroRepository extends JpaRepository<Camarero, Integer>{

}
