package org.smecalculus.bezmen.service;

import org.smecalculus.bezmen.client.SepulkaRegRes;
import org.smecalculus.bezmen.modeling.Sepulka;
import org.smecalculus.bezmen.modeling.SepulkaConverter;

public class SepulkaConverterImpl implements SepulkaConverter {
    public SepulkaRegRes toRegRes(Sepulka sepulka) {
        return new SepulkaRegRes(sepulka.id(), sepulka.name());
    }
}
