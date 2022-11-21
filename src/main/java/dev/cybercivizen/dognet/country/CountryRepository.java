package dev.cybercivizen.dognet.country;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CountryRepository extends CrudRepository<Country, String> {
}
