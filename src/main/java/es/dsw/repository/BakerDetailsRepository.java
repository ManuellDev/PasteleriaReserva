package es.dsw.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.dsw.models.BakerDetails;



public interface BakerDetailsRepository extends JpaRepository<BakerDetails, Integer> {

}
