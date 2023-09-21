package smecalculus.bezmen.core;

import smecalculus.bezmen.messaging.SepulkaRegRes;

public class SepulkaConverterImpl implements SepulkaConverter {
    public SepulkaRegRes toRegRes(Sepulka sepulka) {
        return new SepulkaRegRes(sepulka.id(), sepulka.name());
    }
}
