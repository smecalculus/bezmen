package org.smecalculus.bezmen.fixtures;

import org.smecalculus.bezmen.client.SepulkaRegReq;
import org.smecalculus.bezmen.client.SepulkaRegRes;
import org.smecalculus.bezmen.service.Sepulka;

import java.util.UUID;

public class SepulkaFixtures {

    public static SepulkaRegReq newSepulkaRegReq() {
        return new SepulkaRegReq("foo");
    }

    public static Sepulka.Builder newSepulka() {
        return Sepulka.builder()
                .id(UUID.randomUUID());
    }

    public static Sepulka.Builder newSepulka(UUID id) {
        return newSepulka().id(id);
    }

    public static SepulkaRegRes newSepulkaRegRes() {
        return new SepulkaRegRes(UUID.randomUUID());
    }

    public static SepulkaRegRes newSepulkaRegRes(UUID id) {
        return new SepulkaRegRes(id);
    }
}