package org.example;

import java.util.List;

public class Main {
    @SuppressWarnings("java:S106")
    public static void main(String[] args) {
        KleiderVerwaltung kleiderVerwaltung = new KleiderVerwaltung();
        Kleidungsstueck hose = new Kleidungsstueck("M","Blau","Pakistan");
        Kleidungsstueck hemd = new Kleidungsstueck("L","Weiss","China");
        kleiderVerwaltung.add(hemd);
        kleiderVerwaltung.add(hose);
        List<Kleidungsstueck> klamotten = kleiderVerwaltung.get();
        klamotten.forEach(kleidungsstueck -> System.out.println(kleidungsstueck.getHerstellungsland()));
        kleiderVerwaltung.delete(hemd);
        klamotten = kleiderVerwaltung.get();
        klamotten.forEach(kleidungsstueck -> System.out.println(kleidungsstueck.getHerstellungsland()));

    }
}