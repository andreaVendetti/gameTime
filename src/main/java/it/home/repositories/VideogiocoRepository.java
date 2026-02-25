package it.home.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.home.models.Videogioco;

@Repository
public interface VideogiocoRepository extends CrudRepository<Videogioco, Integer>{

}
