package smecalculus.bezmen.domain.spec;

import java.util.List;
import smecalculus.bezmen.messaging.spec.SepulkaRegReq;

public interface SepulkaService {
    Sepulka register(SepulkaRegReq sepulkaRegReq);

    List<Sepulka> getSepulkas();
}
