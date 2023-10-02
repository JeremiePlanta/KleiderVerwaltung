package org.example.domain;

import io.jexxa.addend.applicationcore.Repository;

import java.util.List;
@Repository
public interface RegistrierungsDatenRepository {

    void add(RegistrierungsDaten registrierungsDaten);

    void remove(Artikelnummer artikelnummer);

    List<RegistrierungsDaten> getAll();

    RegistrierungsDaten get(Artikelnummer artikelnummer);
}
