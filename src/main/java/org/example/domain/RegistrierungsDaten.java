package org.example.domain;

import io.jexxa.addend.applicationcore.Aggregate;
import io.jexxa.addend.applicationcore.AggregateID;

import java.util.UUID;

import static org.example.domain.DomainEventPublisher.publish;

@Aggregate
public class RegistrierungsDaten {
    private final Artikelnummer artikelnummer;

    private final KleidungsstueckDaten kleidungsstueckDaten;

    private final KontaktDaten kontaktDaten;

    private final VerifizierungsCode verifizierungsCode;

    public RegistrierungsDaten(Artikelnummer artikelnummer, KleidungsstueckDaten kleidungsstueckDaten, KontaktDaten kontaktDaten) {
        this.artikelnummer = artikelnummer;
        this.kleidungsstueckDaten = kleidungsstueckDaten;
        this.kontaktDaten = kontaktDaten;
        this.verifizierungsCode = new VerifizierungsCode(UUID.randomUUID().toString());
        sendVerifizierunsCode();
    }

    public void verifiziere(VerifizierungsCode verifizierungsCode) throws UngueltigerVerifizierungsCode {
        if(this.verifizierungsCode != verifizierungsCode){
            throw new UngueltigerVerifizierungsCode();
        }
    }
    @AggregateID
    public Artikelnummer getArtikelnummer() {
        return artikelnummer;
    }

    public KleidungsstueckDaten getKleidungsstueckDaten() {
        return kleidungsstueckDaten;
    }

    public KontaktDaten getKontaktDaten() {
        return kontaktDaten;
    }

    public VerifizierungsCode getVerifizierungsCode() {
        return verifizierungsCode;
    }
    public void sendVerifizierunsCode(){
        publish(new VerifizierungsCodeVerschickt(kontaktDaten.emailAdresse(), verifizierungsCode));
    }
}
