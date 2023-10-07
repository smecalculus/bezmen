package smecalculus.bezmen.interior.core;

import static java.util.UUID.randomUUID;

import java.util.List;
import lombok.NonNull;
import smecalculus.bezmen.exterior.messaging.SepulkaRegisterSlice;
import smecalculus.bezmen.interior.storage.SepulkaDao;

public record SepulkaServiceImpl(@NonNull SepulkaDao sepulkaDao) implements SepulkaService {

    @Override
    public Sepulka register(SepulkaRegisterSlice slice) {
        Sepulka sepulka = Sepulka.builder().id(randomUUID()).name(slice.name()).build();
        return sepulkaDao.save(sepulka);
    }

    @Override
    public List<Sepulka> getSepulkas() {
        return sepulkaDao.getSepulkas();
    }
}
