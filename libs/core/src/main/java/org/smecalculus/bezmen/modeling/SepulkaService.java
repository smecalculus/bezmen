package org.smecalculus.bezmen.modeling;

import org.smecalculus.bezmen.messaging.SepulkaRegReq;

import java.util.List;

public interface SepulkaService {
    Sepulka register(SepulkaRegReq sepulkaRegReq);
    List<Sepulka> getSepulkas();
}
