package org.example;

import io.jexxa.core.JexxaMain;
import io.jexxa.drivingadapter.rest.RESTfulRPCAdapter;
import org.example.domain.KleiderRepository;
import org.example.domain.KleiderVerwaltung;
import org.example.domain.Kleidungsstueck;
import org.example.domainservice.StammdatenService;
import org.example.infrastructure.drivenadapter.persistence.KleiderRepositoryImpl;

import java.util.List;

public class Main {
    @SuppressWarnings("java:S106")
    public static void main(String[] args) {
        KleiderRepository kleiderRepository = new KleiderRepositoryImpl();
        KleiderVerwaltung kleiderVerwaltung = new KleiderVerwaltung(kleiderRepository);
        StammdatenService stammdatenService = new StammdatenService(kleiderRepository);
        stammdatenService.initStammdaten();

        var jexxaMain = new JexxaMain(Main.class);
        jexxaMain
                .bind(RESTfulRPCAdapter.class).to(KleiderVerwaltung.class)
                .bind(RESTfulRPCAdapter.class).to(jexxaMain.getBoundedContext())
                .run();
    }
}