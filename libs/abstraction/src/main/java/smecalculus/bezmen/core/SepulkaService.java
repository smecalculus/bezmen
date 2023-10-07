package smecalculus.bezmen.core;

import java.util.List;
import smecalculus.bezmen.messaging.client.SepulkaRegisterSlice;

public interface SepulkaService {
    Sepulka register(SepulkaRegisterSlice slice);

    List<Sepulka> getSepulkas();
}
