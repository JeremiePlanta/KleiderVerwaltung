package org.example.domain;

import io.jexxa.addend.applicationcore.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RegistrierungsDatenRepository {

    void add(RegistrierungsDaten registrierungsDaten);

    void remove(Artikelnummer artikelnummer);

    List<RegistrierungsDaten> getAll();

    Optional<RegistrierungsDaten> get(Artikelnummer artikelnummer);
}
