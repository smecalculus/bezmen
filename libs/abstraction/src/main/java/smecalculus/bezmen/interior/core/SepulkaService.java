package smecalculus.bezmen.interior.core;

import java.util.List;
import smecalculus.bezmen.exterior.messaging.SepulkaRegisterSlice;

public interface SepulkaService {
    Sepulka register(SepulkaRegisterSlice slice);

    List<Sepulka> getSepulkas();
}
