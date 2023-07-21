package org.example.applicationservice;

import org.example.domain.KleiderRepository;
import org.example.domain.Kleidungsstueck;

import java.util.ArrayList;
import java.util.List;

public class KleiderVerwaltung {
    private final KleiderRepository kleiderverwaltungsliste;

    public KleiderVerwaltung(KleiderRepository kleiderRepository){
        this.kleiderverwaltungsliste = kleiderRepository;
    }

    public void add (Kleidungsstueck kleidungsstueck){
        kleiderverwaltungsliste.add(kleidungsstueck);
    }
    public void delete (Kleidungsstueck kleidungsstueck){
        kleiderverwaltungsliste.remove(kleidungsstueck);
    }
    public List<Kleidungsstueck> get (){
        return kleiderverwaltungsliste.getAll();
    }

}
