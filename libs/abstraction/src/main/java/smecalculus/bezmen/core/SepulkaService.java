package smecalculus.bezmen.core;

import java.util.List;

public interface SepulkaService {
    SepulkaNewResponse register(SepulkaNewRequest request);

    List<Sepulka> getSepulkas();
}
