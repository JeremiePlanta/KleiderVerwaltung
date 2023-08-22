package org.example.domainservice;

import io.jexxa.addend.applicationcore.DomainService;
import org.example.domain.Artikelnummer;
import org.example.domain.KleiderRepository;
import org.example.domain.Kleidungsstueck;
import org.example.domain.KleidungsstueckDaten;

import java.util.List;

@DomainService
public class StammdatenService {
    private final KleiderRepository kleiderRepository;

    public StammdatenService(KleiderRepository kleiderRepository) {
        this.kleiderRepository = kleiderRepository;
    }
    public void initStammdaten(){

        Kleidungsstueck pakistan =new Kleidungsstueck(new Artikelnummer("4353435"), new KleidungsstueckDaten("M","Blau","Pakistan"));
        Kleidungsstueck china =new Kleidungsstueck(new Artikelnummer("5463643364643"), new KleidungsstueckDaten("L","Weiss","China"));

        List<Kleidungsstueck> alleKleider = kleiderRepository.getAll();
        if(!alleKleider.contains(pakistan)){
            kleiderRepository.add(pakistan);
        }
        if(!alleKleider.contains(china)){
            kleiderRepository.add(china);
        }
        kleiderRepository
                .getAll()
                .forEach( element -> System.out.println(element.getArtikelnummer()));
    }
}
