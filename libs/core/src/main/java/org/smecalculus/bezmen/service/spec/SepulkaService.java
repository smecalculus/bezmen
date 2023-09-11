package org.smecalculus.bezmen.service.spec;

import java.util.List;
import org.smecalculus.bezmen.messaging.spec.SepulkaRegReq;

public interface SepulkaService {
    Sepulka register(SepulkaRegReq sepulkaRegReq);

    List<Sepulka> getSepulkas();
}
