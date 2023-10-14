package smecalculus.bezmen.storage;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import smecalculus.bezmen.core.Sepulka;

/**
 * Server side interface
 */
public interface SepulkaDao {

    Optional<Sepulka> getById(UUID id);

    Sepulka save(Sepulka sepulka);

    List<Sepulka> getSepulkas();
}
