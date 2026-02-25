package it.home.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.home.models.TempoDiGioco;

@Repository
public interface TempoRepository extends CrudRepository<TempoDiGioco, Integer> {

}
