package org.smecalculus.bezmen.fixture;

import org.smecalculus.bezmen.client.SepulkaRegReq;
import org.smecalculus.bezmen.client.SepulkaRegRes;
import org.smecalculus.bezmen.domain.Sepulka;

import java.util.UUID;

public class SepulkaFixtures {

    public static SepulkaRegReq sepulkaRegReqPojo() {
        return new SepulkaRegReq("foo");
    }

    public static Sepulka.Builder sepulkaBuilder() {
        return Sepulka.builder()
                .id(UUID.randomUUID());
    }

    public static Sepulka.Builder sepulkaBuilder(UUID id) {
        return sepulkaBuilder().id(id);
    }

    public static Sepulka sepulkaPojo(UUID id) {
        return sepulkaBuilder(id).build();
    }

    public static SepulkaRegRes sepulkaRegResPojo() {
        return new SepulkaRegRes(UUID.randomUUID());
    }

    public static SepulkaRegRes sepulkaRegResPojo(UUID id) {
        return new SepulkaRegRes(id);
    }
}