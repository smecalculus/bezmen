package org.smecalculus.bezmen.service;

import org.smecalculus.bezmen.client.SepulkaRegRes;
import org.smecalculus.bezmen.modeling.Sepulka;
import org.smecalculus.bezmen.modeling.SepulkaConverter;

public class SepulkaConverterDefault implements SepulkaConverter {
    public SepulkaRegRes convert(Sepulka sepulka) {
        return new SepulkaRegRes(sepulka.id(), sepulka.name());
    }
}
