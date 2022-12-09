package dev.cybercivizen.dognet.repository;

import dev.cybercivizen.dognet.model.Country;
import org.springframework.data.repository.CrudRepository;

public interface CountryRepository extends CrudRepository<Country, String> {
}
