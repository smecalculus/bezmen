package org.smecalculus.bezmen.service.impl;

import org.smecalculus.bezmen.messaging.spec.SepulkaRegRes;
import org.smecalculus.bezmen.service.spec.Sepulka;
import org.smecalculus.bezmen.service.spec.SepulkaConverter;

public class SepulkaConverterImpl implements SepulkaConverter {
    public SepulkaRegRes toRegRes(Sepulka sepulka) {
        return new SepulkaRegRes(sepulka.id(), sepulka.name());
    }
}
