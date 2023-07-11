package org.example.infrastructure.drivenadapter.persistence;

import org.example.domain.KleiderRepository;
import org.example.domain.Kleidungsstueck;

import java.util.ArrayList;
import java.util.List;

public class KleiderRepositoryImpl implements KleiderRepository {

    private final List<Kleidungsstueck> kleiderverwaltungsliste= new ArrayList<>();

    @Override
    public List<Kleidungsstueck> getAll(){return kleiderverwaltungsliste;}

    @Override
    public void remove(Kleidungsstueck kleidungsstueck) {
        kleiderverwaltungsliste.remove(kleidungsstueck);
    }
    @Override
    public void add(Kleidungsstueck kleidungsstueck){
        kleiderverwaltungsliste.add(kleidungsstueck);
    }
}
