package org.smecalculus.bezmen.data;

import org.smecalculus.bezmen.domain.Sepulka;

import java.util.List;
import java.util.UUID;

public interface SepulkaDao {

    Sepulka getById(UUID id);

    Sepulka save(Sepulka sepulka);

    List<Sepulka> getSepulkas();
}
