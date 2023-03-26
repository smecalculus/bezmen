package org.smecalculus.bezmen.fixture;

import org.smecalculus.bezmen.client.SepulkaRegReq;
import org.smecalculus.bezmen.client.SepulkaRegRes;
import org.smecalculus.bezmen.domain.Sepulka;

import java.util.UUID;

public class SepulkaFixtures {
    public static final String NAME = "foo";

    public static SepulkaRegReq sepulkaRegReqPojo() {
        return new SepulkaRegReq(NAME);
    }

    public static Sepulka.Builder sepulkaBuilder() {
        return Sepulka.builder()
                .id(UUID.randomUUID())
                .name(NAME);
    }

    public static Sepulka.Builder sepulkaBuilder(UUID id) {
        return sepulkaBuilder().id(id);
    }

    public static Sepulka sepulkaPojo(UUID id) {
        return sepulkaBuilder(id).build();
    }

    public static SepulkaRegRes sepulkaRegResPojo() {
        return new SepulkaRegRes(UUID.randomUUID(), NAME);
    }

    public static SepulkaRegRes sepulkaRegResPojo(String name) {
        return new SepulkaRegRes(UUID.randomUUID(), name);
    }

    public static SepulkaRegRes sepulkaRegResPojo(UUID id) {
        return new SepulkaRegRes(id, NAME);
    }
}