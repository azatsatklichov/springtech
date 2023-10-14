package net.sahet.springtech.service;

import net.sahet.springtech.domain.Kitap;
import net.sahet.springtech.repository.KitapRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class KitapService {

	@Autowired
	private KitapRepository repository;

	public String getKitapById(long id) {
		log.debug("getKitapById: " + id);
		Optional<Kitap> bookById = repository.findById(id);
		return bookById.isPresent() ? bookById.get().getName() : "";
	}

	public List<Kitap> getAllKitaps(String name) {
		log.debug("getAllKitaps by name: " + name);
		return repository.findByName(name);
	}
}
