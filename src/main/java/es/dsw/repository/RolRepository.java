package es.dsw.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.dsw.models.Roles;

@Repository
public interface RolRepository extends JpaRepository<Roles, Integer> {
    // Puedes añadir métodos personalizados de consulta si lo necesitas
}
