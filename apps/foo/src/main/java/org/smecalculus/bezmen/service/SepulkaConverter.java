package org.smecalculus.bezmen.service;

import org.smecalculus.bezmen.client.SepulkaRegRes;
import org.smecalculus.bezmen.domain.Sepulka;

public class SepulkaConverter {
    public SepulkaRegRes convert(Sepulka sepulka) {
        return new SepulkaRegRes(sepulka.id());
    }
}
