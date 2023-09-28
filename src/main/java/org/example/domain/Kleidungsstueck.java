package org.example.domain;

import io.jexxa.addend.applicationcore.Aggregate;
import io.jexxa.addend.applicationcore.AggregateID;

import java.util.Objects;

@Aggregate
public class Kleidungsstueck {
    private final KleidungsstueckDaten kleidungsstueckDaten;

    private final KontaktDaten kontaktDaten;
    private final Artikelnummer artikelnummer;

    public Kleidungsstueck(Artikelnummer artikelnummer, KleidungsstueckDaten kleidungsstueckDaten, KontaktDaten kontaktDaten) {
        this.kleidungsstueckDaten = kleidungsstueckDaten;
        this.artikelnummer = artikelnummer;
        this.kontaktDaten = kontaktDaten;
    }

    @SuppressWarnings("unused")
    public String getGroesse() {
        return kleidungsstueckDaten.groesse();
    }

    @SuppressWarnings("unused")
    public String getFarbe() {
        return kleidungsstueckDaten.farbe();
    }
    @SuppressWarnings("unused")
    public String getHerstellungsland() {
        return kleidungsstueckDaten.herstellungsland();
    }
    @AggregateID
    public Artikelnummer getArtikelnummer() {
        return this.artikelnummer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Kleidungsstueck that = (Kleidungsstueck) o;
        return Objects.equals(artikelnummer, that.artikelnummer);
    }
    public KontaktDaten getKontaktDaten(){return this.kontaktDaten;}

}
