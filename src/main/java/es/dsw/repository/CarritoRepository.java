package es.dsw.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.dsw.models.Carrito;

@Repository
public interface CarritoRepository extends JpaRepository<Carrito, Integer> {
}
