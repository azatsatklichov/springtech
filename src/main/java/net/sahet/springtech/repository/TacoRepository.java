package net.sahet.springtech.repository;

import org.springframework.data.repository.CrudRepository;

import net.sahet.springtech.domain.Taco;

public interface TacoRepository extends CrudRepository<Taco, Long> {

}
