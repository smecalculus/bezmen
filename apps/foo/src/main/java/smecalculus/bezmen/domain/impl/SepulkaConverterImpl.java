package smecalculus.bezmen.domain.impl;

import smecalculus.bezmen.domain.spec.Sepulka;
import smecalculus.bezmen.domain.spec.SepulkaConverter;
import smecalculus.bezmen.messaging.spec.SepulkaRegRes;

public class SepulkaConverterImpl implements SepulkaConverter {
    public SepulkaRegRes toRegRes(Sepulka sepulka) {
        return new SepulkaRegRes(sepulka.id(), sepulka.name());
    }
}
