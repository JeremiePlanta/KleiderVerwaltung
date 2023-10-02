package org.example.domain;

import java.util.List;

public interface RegistrierungsDatenRepository {

    void add(RegistrierungsDaten registrierungsDaten);

    void remove(Artikelnummer artikelnummer);

    List<RegistrierungsDaten> getAll();

    RegistrierungsDaten get(Artikelnummer artikelnummer);
}
