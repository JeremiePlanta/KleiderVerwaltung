package org.example.domain;

import io.jexxa.addend.applicationcore.Repository;

import java.util.List;

@Repository
public interface KleiderRepository {
    List<Kleidungsstueck> getAll();

    void remove(Artikelnummer artikelnummer);

    void add (Kleidungsstueck kleidungsstueck);
}
