package org.example.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class RegistrierungsDatenTest {

    @Test
    void testErstelleVerifizierungsCode(){

        //Arrange
        var artikelnummer = new Artikelnummer("43436869438943");
        var kleidungsstueckDaten = new KleidungsstueckDaten("M", "Rosa", "China");
        var kontaktDaten = new KontaktDaten(new EmailAdresse("Hosenträger@genius.jog"),"Hose", "Trag");
        var objectUnderTest = new RegistrierungsDaten(artikelnummer, kleidungsstueckDaten, kontaktDaten);
        var empfangeneDomainEvents = new ArrayList<VerifizierungsCodeVerschickt>();
        DomainEventPublisher.subscribe(VerifizierungsCodeVerschickt.class, empfangeneDomainEvents::add);

        //Act
        objectUnderTest.sendVerifizierunsCode();

        //Assert
        assertEquals(1, empfangeneDomainEvents.size());
        //Note: A UUID actually a 128 bit value (2 long). To represent 128 bit into hex string there will be 128/4=32 char (each char is 4bit long). In string format it also contains 4 (-) that's why the length is 36.
        assertEquals(36, empfangeneDomainEvents.get(0).verifizierungsCode().verifizierungsCode().length());
    }

}