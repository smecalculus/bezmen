package org.smecalculus.bezmen.modeling;

import java.util.List;
import org.smecalculus.bezmen.messaging.SepulkaRegReq;

public interface SepulkaService {
    Sepulka register(SepulkaRegReq sepulkaRegReq);

    List<Sepulka> getSepulkas();
}
