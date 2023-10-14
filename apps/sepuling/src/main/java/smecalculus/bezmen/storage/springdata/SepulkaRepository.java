package smecalculus.bezmen.storage.springdata;

import org.springframework.data.repository.CrudRepository;
import smecalculus.bezmen.storage.SepulkaEdge;

public interface SepulkaRepository extends CrudRepository<SepulkaEdge, String> {}
