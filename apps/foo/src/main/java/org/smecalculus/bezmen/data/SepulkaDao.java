package org.smecalculus.bezmen.data;

import java.util.List;
import java.util.UUID;
import org.smecalculus.bezmen.modeling.Sepulka;

public interface SepulkaDao {

    Sepulka getById(UUID id);

    Sepulka save(Sepulka sepulka);

    List<Sepulka> getSepulkas();
}
