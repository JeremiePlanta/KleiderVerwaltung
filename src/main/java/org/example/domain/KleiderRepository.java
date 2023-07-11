package org.example.domain;

import java.util.List;

public interface KleiderRepository {
    List<Kleidungsstueck> getAll();

    void remove(Kleidungsstueck kleidungsstueck);

    void add (Kleidungsstueck kleidungsstueck);
}
