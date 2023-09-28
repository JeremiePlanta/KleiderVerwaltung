package org.example.applicationservice;

import io.jexxa.addend.applicationcore.ApplicationService;
import org.example.domain.*;

import java.util.List;

@ApplicationService
public class KleiderVerwaltung {
    private final KleiderRepository kleiderverwaltungsliste;

    public KleiderVerwaltung(KleiderRepository kleiderRepository){
        this.kleiderverwaltungsliste = kleiderRepository;
    }

    public void add (Artikelnummer artikelnummer, KleidungsstueckDaten kleidungsstueckDaten, KontaktDaten kontaktDaten){
        kleiderverwaltungsliste.add(new Kleidungsstueck(artikelnummer,kleidungsstueckDaten, kontaktDaten));
    }
    public void delete (Artikelnummer artikelnummer){
        kleiderverwaltungsliste.remove(artikelnummer);
    }
    public List<Artikelnummer> get (){
        return kleiderverwaltungsliste.getAll().stream().map(Kleidungsstueck::getArtikelnummer).toList();
    }

    public void registriere(Artikelnummer artikelnummer, KleidungsstueckDaten kleidungsstueckDaten, KontaktDaten kontaktDaten){

    }

    public void verifiziere(Artikelnummer artikelnummer, VerifizierungsCode verifizierungsCode){

    }

}
