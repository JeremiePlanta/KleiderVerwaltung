package org.example.domain;

import io.jexxa.addend.applicationcore.ValueObject;

@ValueObject
public record KleidungsstueckDaten(String groesse, String farbe, String herstellungsland) {
}
