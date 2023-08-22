package org.example.domain;

import io.jexxa.addend.applicationcore.Aggregate;

import java.util.Objects;

@Aggregate
public class Kleidungsstueck {
    private final String groesse;
    private final String farbe;
    private final String herstellungsland;

    private final String artikelnummer;

    public Kleidungsstueck(String groesse, String farbe, String herstellungsland, String artikelnummer) {
        this.groesse = groesse;
        this.farbe = farbe;
        this.herstellungsland = herstellungsland;
        this.artikelnummer = artikelnummer;
    }

    @SuppressWarnings("unused")
    public String getGroesse() {
        return groesse;
    }

    @SuppressWarnings("unused")
    public String getFarbe() {
        return farbe;
    }
    @SuppressWarnings("unused")
    public String getHerstellungsland() {
        return herstellungsland;
    }

    public String getArtikelnummer() {
        return artikelnummer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Kleidungsstueck that = (Kleidungsstueck) o;
        return Objects.equals(groesse, that.groesse) && Objects.equals(farbe, that.farbe) && Objects.equals(herstellungsland, that.herstellungsland) && Objects.equals(artikelnummer, that.artikelnummer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(groesse, farbe, herstellungsland);
    }

}
