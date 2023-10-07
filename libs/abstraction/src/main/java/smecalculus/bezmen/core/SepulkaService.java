package smecalculus.bezmen.core;

import java.util.List;
import smecalculus.bezmen.messaging.client.SepulkaRegReq;

public interface SepulkaService {
    Sepulka register(SepulkaRegReq sepulkaRegReq);

    List<Sepulka> getSepulkas();
}
