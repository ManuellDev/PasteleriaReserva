package es.dsw.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.dsw.models.User;
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    // Buscar un usuario por su nombre de usuario
    User findByUsername(String username);
}

