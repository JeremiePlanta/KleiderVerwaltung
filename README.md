# Motivation 
Ein Projekt um die Grundlagen der Software-Entwicklung zu lernen.
Die Firma bekommt von Kunden Kleidung zur lagerung, für die Verwaltung der Kleidungsstücke wird diese Anwendung verwendet. 

Dieses Projekt soll folgende Funktionalität anbieten:
- Hinzufügen eines Kleidungstücks in die KleiderVerwaltung
- Löschen eines Kleidungstücks aus der KleiderVerwaltung
- Abfragen aller Kleidungstücke aus der KleiderVerwaltung

[User-Story Kleidungsregistrierung]Als Lagermitarbeiter möchte ich, dass Kunden ihr Kleidungsstück registrieren müssen, damit ich die möglichkeit habe die RegistrierungsDaten automatisch zu verifizieren.
- Bei der Registrierung müssen gültige KontaktDaten und kleidungsstueckDaten angegeben werden.
- Es wird ein 6-stelliger VerifizierungsCode an die angegebene E-Mail-Adresse verschickt
- Der VerifizierungsCode muss zusammen mit der Seriennummer übergeben werden, damit das Kleidungsstueck in die KleiderVerwaltung hinzugefügt wird
- Der VerifizierungsCode verliert nach 24 Stunden seine Gültigkeit

Abbildung auf DDD Mustersprache und Klassen:
ApplicationService: 
    KleiderVerwaltung
        Neue Methoden registriere und verifiziere
ValueObject:
    KontaktDaten
    EmailAdresse
    VerifizierungsCode
Aggregate:
    Kleidungsstueck
    RegistrierungsDaten
Repository:
    KleiderRepository
    RegistrierungsDatenRepository
DomainEvent:
    VerifizierungsCodeVerschickt
