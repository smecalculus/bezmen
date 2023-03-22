package org.smecalculus.bezmen.foo.fixtures;

import org.smecalculus.bezmen.client.SepulkaRegReq;
import org.smecalculus.bezmen.client.SepulkaRegRes;
import org.smecalculus.bezmen.foo.service.Sepulka;

import java.util.UUID;

public class SepulkaFixtures {

    public static Sepulka.Builder newSepulka() {
        return Sepulka.builder()
                .id(UUID.randomUUID());
    }

    public static SepulkaRegRes newSepulkaRegRes() {
        return new SepulkaRegRes("foo");
    }

    public static SepulkaRegReq newSepulkaRegReq() {
        return new SepulkaRegReq();
    }
}