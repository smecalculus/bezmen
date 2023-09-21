package smecalculus.bezmen.core;

import java.util.List;
import smecalculus.bezmen.messaging.SepulkaRegReq;

public interface SepulkaService {
    Sepulka register(SepulkaRegReq sepulkaRegReq);

    List<Sepulka> getSepulkas();
}
