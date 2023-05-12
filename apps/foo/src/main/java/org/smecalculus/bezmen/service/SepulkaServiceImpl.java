package org.smecalculus.bezmen.service;

import static java.util.UUID.randomUUID;

import java.util.List;
import lombok.NonNull;
import org.smecalculus.bezmen.data.SepulkaDao;
import org.smecalculus.bezmen.messaging.SepulkaRegReq;
import org.smecalculus.bezmen.modeling.Sepulka;
import org.smecalculus.bezmen.modeling.SepulkaService;

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
