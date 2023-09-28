package org.example.domainservice;

import io.jexxa.addend.applicationcore.DomainService;
import org.example.domain.*;

import java.util.List;

@DomainService
public class StammdatenService {
    private final KleiderRepository kleiderRepository;

    public StammdatenService(KleiderRepository kleiderRepository) {
        this.kleiderRepository = kleiderRepository;
    }
    public void initStammdaten(){

        Kleidungsstueck pakistan =new Kleidungsstueck(new Artikelnummer("4353435"), new KleidungsstueckDaten("M","Blau","Pakistan"), new KontaktDaten(new EmailAdresse("Timothi@gobbl.lu"), "Roll", "Pate"));
        Kleidungsstueck china =new Kleidungsstueck(new Artikelnummer("5463643364643"), new KleidungsstueckDaten("L","Weiss","China"), new KontaktDaten(new EmailAdresse("goegde@sfg.con"), "Fedora", "Megusta"));

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
