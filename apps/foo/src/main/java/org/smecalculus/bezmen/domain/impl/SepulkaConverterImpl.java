package org.smecalculus.bezmen.domain.impl;

import org.smecalculus.bezmen.domain.spec.Sepulka;
import org.smecalculus.bezmen.domain.spec.SepulkaConverter;
import org.smecalculus.bezmen.messaging.spec.SepulkaRegRes;

public class SepulkaConverterImpl implements SepulkaConverter {
    public SepulkaRegRes toRegRes(Sepulka sepulka) {
        return new SepulkaRegRes(sepulka.id(), sepulka.name());
    }
}
