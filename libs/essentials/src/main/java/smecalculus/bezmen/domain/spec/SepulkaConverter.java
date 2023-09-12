package smecalculus.bezmen.domain.spec;

import smecalculus.bezmen.messaging.spec.SepulkaRegRes;

public interface SepulkaConverter {
    SepulkaRegRes toRegRes(Sepulka sepulka);
}
