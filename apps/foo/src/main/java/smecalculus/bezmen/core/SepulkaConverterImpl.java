package smecalculus.bezmen.core;

import smecalculus.bezmen.messaging.client.SepulkaRegRes;

public class SepulkaConverterImpl implements SepulkaConverter {
    public SepulkaRegRes toRegRes(Sepulka sepulka) {
        return new SepulkaRegRes(sepulka.id(), sepulka.name());
    }
}
