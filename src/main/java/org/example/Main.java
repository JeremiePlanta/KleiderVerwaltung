package org.example;

import io.jexxa.core.JexxaMain;
import io.jexxa.drivingadapter.rest.RESTfulRPCAdapter;
import org.example.domain.KleiderRepository;
import org.example.applicationservice.KleiderVerwaltung;
import org.example.domainservice.StammdatenService;
import org.example.infrastructure.drivenadapter.persistence.KleiderRepositoryImpl;

import java.util.Properties;

public class Main {
    @SuppressWarnings("java:S106")
    public static void main(String[] args) {
        KleiderRepository kleiderRepository = new KleiderRepositoryImpl(new Properties());
        KleiderVerwaltung kleiderVerwaltung = new KleiderVerwaltung(kleiderRepository);
        StammdatenService stammdatenService = new StammdatenService(kleiderRepository);
        stammdatenService.initStammdaten();

        var jexxaMain = new JexxaMain(Main.class);
        jexxaMain
                .bind(RESTfulRPCAdapter.class).to(kleiderVerwaltung)
                .bind(RESTfulRPCAdapter.class).to(jexxaMain.getBoundedContext())
                .run();
    }
}