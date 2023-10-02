package org.example.domain;

import io.jexxa.addend.applicationcore.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface KleiderRepository {
    List<Kleidungsstueck> getAll();

    void remove(Artikelnummer artikelnummer);

    void add (Kleidungsstueck kleidungsstueck);

    Optional<Kleidungsstueck> get(Artikelnummer artikelnummer);

    void update(Kleidungsstueck kleidungsstueck);
}
