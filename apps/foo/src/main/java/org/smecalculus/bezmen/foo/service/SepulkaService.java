package org.smecalculus.bezmen.foo.service;

import org.smecalculus.bezmen.client.SepulkaRegReq;

import java.util.List;

public interface SepulkaService {
    Sepulka register(SepulkaRegReq sepulkaRegReq);
    List<Sepulka> getSepulkas();
}
