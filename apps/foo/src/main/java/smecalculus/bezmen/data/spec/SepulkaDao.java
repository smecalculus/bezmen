package smecalculus.bezmen.data.spec;

import java.util.List;
import java.util.UUID;
import smecalculus.bezmen.domain.spec.Sepulka;

public interface SepulkaDao {

    Sepulka getById(UUID id);

    Sepulka save(Sepulka sepulka);

    List<Sepulka> getSepulkas();
}
