package smecalculus.bezmen.core;

import smecalculus.bezmen.messaging.client.SepulkaRegRes;

public interface SepulkaConverter {
    SepulkaRegRes toRegRes(Sepulka sepulka);
}
