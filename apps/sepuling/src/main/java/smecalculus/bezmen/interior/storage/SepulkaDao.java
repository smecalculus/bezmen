package smecalculus.bezmen.interior.storage;

import java.util.List;
import java.util.UUID;
import smecalculus.bezmen.interior.core.Sepulka;

public interface SepulkaDao {

    Sepulka getById(UUID id);

    Sepulka save(Sepulka sepulka);

    List<Sepulka> getSepulkas();
}
