package org.example.domainservice;

import org.example.domain.KleiderRepository;
import org.example.domain.Kleidungsstueck;

import java.util.List;

public class StammdatenService {
    private static final Kleidungsstueck pakistan =new Kleidungsstueck("M","Blau","Pakistan");
    private static final Kleidungsstueck china =new Kleidungsstueck("L","Weiss","China");

    private final KleiderRepository kleiderRepository;

    public StammdatenService(KleiderRepository kleiderRepository) {
        this.kleiderRepository = kleiderRepository;
    }
    public void initStammdaten(){

        List<Kleidungsstueck> alleKleider = kleiderRepository.getAll();
        if(!alleKleider.contains(pakistan)){
            kleiderRepository.add(pakistan);
        }
        if(!alleKleider.contains(china)){
            kleiderRepository.add(china);
        }
        kleiderRepository
                .getAll()
                .forEach( element -> System.out.println(element.getHerstellungsland()));
    }
}
