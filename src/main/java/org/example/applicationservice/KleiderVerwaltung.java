package org.example.applicationservice;

import io.jexxa.addend.applicationcore.ApplicationService;
import org.example.domain.Artikelnummer;
import org.example.domain.KleiderRepository;
import org.example.domain.Kleidungsstueck;
import org.example.domain.KleidungsstueckDaten;

import java.util.ArrayList;
import java.util.List;

@ApplicationService
public class KleiderVerwaltung {
    private final KleiderRepository kleiderverwaltungsliste;

    public KleiderVerwaltung(KleiderRepository kleiderRepository){
        this.kleiderverwaltungsliste = kleiderRepository;
    }

    public void add (Artikelnummer artikelnummer, KleidungsstueckDaten kleidungsstueckDaten){
        kleiderverwaltungsliste.add(new Kleidungsstueck(artikelnummer,kleidungsstueckDaten));
    }
    public void delete (Artikelnummer artikelnummer){
        kleiderverwaltungsliste.remove(artikelnummer);
    }
    public List<Artikelnummer> get (){
        return kleiderverwaltungsliste.getAll().stream().map(Kleidungsstueck::getArtikelnummer).toList();
    }

}
