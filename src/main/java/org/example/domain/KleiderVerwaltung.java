package org.example.domain;

import java.util.ArrayList;
import java.util.List;

public class KleiderVerwaltung {
    private final List<Kleidungsstueck> kleiderverwaltungsliste= new ArrayList<>();

    public void add (Kleidungsstueck kleidungsstueck){
        kleiderverwaltungsliste.add(kleidungsstueck);
    }
    public void delete (Kleidungsstueck kleidungsstueck){
        kleiderverwaltungsliste.remove(kleidungsstueck);
    }
    public List<Kleidungsstueck> get (){
        return this.kleiderverwaltungsliste;
    }

}
