package org.example.infrastructure.drivenadapter.persistence;

import io.jexxa.addend.infrastructure.DrivenAdapter;
import io.jexxa.infrastructure.RepositoryManager;
import io.jexxa.infrastructure.persistence.repository.IRepository;
import org.example.domain.Artikelnummer;
import org.example.domain.RegistrierungsDaten;
import org.example.domain.RegistrierungsDatenRepository;

import java.util.List;
import java.util.Optional;
import java.util.Properties;

@DrivenAdapter
public class RegistrierungsDatenRepositoryImpl implements RegistrierungsDatenRepository {
    private final IRepository<RegistrierungsDaten, Artikelnummer> repository;

    public RegistrierungsDatenRepositoryImpl(Properties properties){
        this.repository = RepositoryManager.getRepository(RegistrierungsDaten.class, RegistrierungsDaten::getArtikelnummer, properties);
    }

    @Override
    public void add(RegistrierungsDaten registrierungsDaten) {
        repository.add(registrierungsDaten);
    }

    @Override
    public void remove(Artikelnummer artikelnummer) {
        repository.remove(artikelnummer);
    }

    @Override
    public List<RegistrierungsDaten> getAll() {
        return repository.get();
    }

    @Override
    public Optional<RegistrierungsDaten> get(Artikelnummer artikelnummer) {
        return repository.get(artikelnummer);
    }
}
