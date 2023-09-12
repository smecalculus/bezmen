package org.smecalculus.bezmen.domain.spec;

import org.smecalculus.bezmen.messaging.spec.SepulkaRegRes;

public interface SepulkaConverter {
    SepulkaRegRes toRegRes(Sepulka sepulka);
}
