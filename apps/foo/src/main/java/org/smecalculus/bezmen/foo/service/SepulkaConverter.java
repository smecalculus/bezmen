package org.smecalculus.bezmen.foo.service;

import org.smecalculus.bezmen.client.SepulkaRegRes;

public class SepulkaConverter {
    public SepulkaRegRes convert(Sepulka sepulka) {
        return new SepulkaRegRes(sepulka.id().toString());
    }
}
