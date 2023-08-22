package org.example.domain;

import io.jexxa.addend.applicationcore.Repository;

import java.util.List;

@Repository
public interface KleiderRepository {
    List<Kleidungsstueck> getAll();

    void remove(Kleidungsstueck kleidungsstueck);

    void add (Kleidungsstueck kleidungsstueck);
}
