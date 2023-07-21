package org.example.infrastructure.drivenadapter.persistence;

import io.jexxa.infrastructure.RepositoryManager;
import io.jexxa.infrastructure.persistence.repository.IRepository;
import org.example.domain.KleiderRepository;
import org.example.domain.Kleidungsstueck;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class KleiderRepositoryImpl implements KleiderRepository {

    private final IRepository<Kleidungsstueck, String> kleiderRepository;

    public KleiderRepositoryImpl(Properties properties) {
        this.kleiderRepository = RepositoryManager.getRepository(Kleidungsstueck.class, Kleidungsstueck::getArtikelnummer, properties);
    }

    @Override
    public List<Kleidungsstueck> getAll(){return kleiderRepository.get();}

    @Override
    public void remove(Kleidungsstueck kleidungsstueck) {
        kleiderRepository.remove(kleidungsstueck.getArtikelnummer());
    }
    @Override
    public void add(Kleidungsstueck kleidungsstueck){
        kleiderRepository.add(kleidungsstueck);
    }
}
