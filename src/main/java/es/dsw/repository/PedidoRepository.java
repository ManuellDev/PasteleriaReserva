package es.dsw.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.dsw.models.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer> {
}

