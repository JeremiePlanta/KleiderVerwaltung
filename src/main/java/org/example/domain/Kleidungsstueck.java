package org.example.domain;

import java.util.Objects;

public class Kleidungsstueck {
    private final String groesse;
    private final String farbe;
    private final String herstellungsland;

    public Kleidungsstueck(String groesse, String farbe, String herstellungsland) {
        this.groesse = groesse;
        this.farbe = farbe;
        this.herstellungsland = herstellungsland;
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
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Kleidungsstueck that = (Kleidungsstueck) o;
        return Objects.equals(groesse, that.groesse) && Objects.equals(farbe, that.farbe) && Objects.equals(herstellungsland, that.herstellungsland);
    }

    @Override
    public int hashCode() {
        return Objects.hash(groesse, farbe, herstellungsland);
    }

}
