package net.sahet.springtech.repository;

import net.sahet.springtech.domain.Kitap;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface KitapRepository extends CrudRepository<Kitap, Long> {

    List<Kitap> findByName(String name);

    Optional<Kitap> findById(Long longs);
}
