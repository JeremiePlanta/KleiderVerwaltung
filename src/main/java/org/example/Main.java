package org.example;

import io.jexxa.core.JexxaMain;
import io.jexxa.drivingadapter.rest.RESTfulRPCAdapter;
import org.example.domain.KleiderVerwaltung;
import org.example.domain.Kleidungsstueck;
import org.example.infrastructure.drivenadapter.persistence.KleiderRepositoryImpl;

import java.util.List;

public class Main {
    @SuppressWarnings("java:S106")
    public static void main(String[] args) {
        KleiderVerwaltung kleiderVerwaltung = new KleiderVerwaltung(new KleiderRepositoryImpl());
        Kleidungsstueck hose = new Kleidungsstueck("M","Blau","Pakistan");
        Kleidungsstueck hemd = new Kleidungsstueck("L","Weiss","China");
        kleiderVerwaltung.add(hemd);
        kleiderVerwaltung.add(hose);
        List<Kleidungsstueck> klamotten = kleiderVerwaltung.get();
        klamotten.forEach(kleidungsstueck -> System.out.println(kleidungsstueck.getHerstellungsland()));
        kleiderVerwaltung.delete(hemd);
        klamotten = kleiderVerwaltung.get();
        klamotten.forEach(kleidungsstueck -> System.out.println(kleidungsstueck.getHerstellungsland()));
        var jexxaMain = new JexxaMain(Main.class);
        jexxaMain
                .bind(RESTfulRPCAdapter.class).to(KleiderVerwaltung.class)
                .bind(RESTfulRPCAdapter.class).to(jexxaMain.getBoundedContext())
                .run();
    }
}