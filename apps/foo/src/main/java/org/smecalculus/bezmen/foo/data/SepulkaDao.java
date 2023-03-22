package org.smecalculus.bezmen.foo.data;

import org.smecalculus.bezmen.foo.service.Sepulka;

import java.util.List;
import java.util.UUID;

public interface SepulkaDao {

    Sepulka getById(UUID id);

    Sepulka save(Sepulka sepulka);

    List<Sepulka> getSepulkas();
}
