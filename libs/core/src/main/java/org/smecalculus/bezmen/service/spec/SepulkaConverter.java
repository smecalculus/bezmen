package org.smecalculus.bezmen.service.spec;

import org.smecalculus.bezmen.messaging.spec.SepulkaRegRes;

public interface SepulkaConverter {
    SepulkaRegRes toRegRes(Sepulka sepulka);
}
