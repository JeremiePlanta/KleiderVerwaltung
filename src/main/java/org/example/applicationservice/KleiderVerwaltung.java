package org.example.applicationservice;

import io.jexxa.addend.applicationcore.ApplicationService;
import org.example.domain.*;

import java.util.List;

@ApplicationService
public class KleiderVerwaltung {
    private final KleiderRepository kleiderverwaltungsliste;

    private final  RegistrierungsDatenRepository registrierungsDatenListe;

    public KleiderVerwaltung(KleiderRepository kleiderRepository, RegistrierungsDatenRepository registrierungsDatenRepository){
        this.kleiderverwaltungsliste = kleiderRepository;
        this.registrierungsDatenListe =registrierungsDatenRepository;
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
    public void aktualisiere(Artikelnummer artikelnummer, KleidungsstueckDaten kleidungsstueckDaten, KontaktDaten kontaktDaten){
        Kleidungsstueck kleidungsstueck = kleiderverwaltungsliste.get(artikelnummer).orElseThrow();

        kleidungsstueck.aktualisiere(kleidungsstueckDaten, kontaktDaten);
        kleiderverwaltungsliste.update(kleidungsstueck);
    }

    public void registriere(Artikelnummer artikelnummer, KleidungsstueckDaten kleidungsstueckDaten, KontaktDaten kontaktDaten){
        registrierungsDatenListe.add(new RegistrierungsDaten(artikelnummer, kleidungsstueckDaten, kontaktDaten));
    }

    public void verifiziere(Artikelnummer artikelnummer, VerifizierungsCode verifizierungsCode) throws UngueltigerVerifizierungsCode {
        RegistrierungsDaten registrierungsDaten = registrierungsDatenListe.get(artikelnummer).orElseThrow();
        registrierungsDaten.verifiziere(verifizierungsCode);

        kleiderverwaltungsliste.add(new Kleidungsstueck(artikelnummer,registrierungsDaten.getKleidungsstueckDaten(), registrierungsDaten.getKontaktDaten()));
        registrierungsDatenListe.remove(artikelnummer);

    }

}
