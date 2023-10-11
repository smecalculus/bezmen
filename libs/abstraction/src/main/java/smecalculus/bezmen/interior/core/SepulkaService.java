package smecalculus.bezmen.interior.core;

import java.util.List;
import smecalculus.bezmen.exterior.messaging.SepulkaRegisterSlice;
import smecalculus.bezmen.exterior.messaging.SepulkaRegisteredSlice;

public interface SepulkaService {
    SepulkaRegisteredSlice register(SepulkaRegisterSlice slice);

    List<Sepulka> getSepulkas();
}
