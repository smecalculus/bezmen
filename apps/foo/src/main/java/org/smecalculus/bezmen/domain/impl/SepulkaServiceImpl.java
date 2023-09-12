package org.smecalculus.bezmen.domain.impl;

import static java.util.UUID.randomUUID;

import java.util.List;
import lombok.NonNull;
import org.smecalculus.bezmen.data.spec.SepulkaDao;
import org.smecalculus.bezmen.domain.spec.Sepulka;
import org.smecalculus.bezmen.domain.spec.SepulkaService;
import org.smecalculus.bezmen.messaging.spec.SepulkaRegReq;

public record SepulkaServiceImpl(@NonNull SepulkaDao sepulkaDao) implements SepulkaService {

    @Override
    public Sepulka register(SepulkaRegReq sepulkaRegReq) {
        Sepulka sepulka =
                Sepulka.builder().id(randomUUID()).name(sepulkaRegReq.name()).build();
        return sepulkaDao.save(sepulka);
    }

    @Override
    public List<Sepulka> getSepulkas() {
        return sepulkaDao.getSepulkas();
    }
}
