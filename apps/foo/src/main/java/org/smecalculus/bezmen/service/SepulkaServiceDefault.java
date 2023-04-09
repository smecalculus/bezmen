package org.smecalculus.bezmen.service;

import lombok.NonNull;
import org.smecalculus.bezmen.client.SepulkaRegReq;
import org.smecalculus.bezmen.data.SepulkaDao;
import org.smecalculus.bezmen.modeling.Sepulka;
import org.smecalculus.bezmen.modeling.SepulkaService;

import java.util.List;

import static java.util.UUID.randomUUID;

public record SepulkaServiceDefault(
        @NonNull SepulkaDao sepulkaDao
) implements SepulkaService {

    @Override
    public Sepulka register(SepulkaRegReq sepulkaRegReq) {
        Sepulka sepulka = Sepulka.builder()
                .id(randomUUID())
                .name(sepulkaRegReq.name())
                .build();
        return sepulkaDao.save(sepulka);
    }

    @Override
    public List<Sepulka> getSepulkas() {
        return sepulkaDao.getSepulkas();
    }
}
