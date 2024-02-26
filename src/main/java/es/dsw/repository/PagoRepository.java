package es.dsw.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.dsw.models.Pago;

@Repository
public interface PagoRepository extends JpaRepository<Pago, Integer> {
}
