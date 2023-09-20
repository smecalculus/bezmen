package smecalculus.bezmen.fixture;

import java.util.UUID;
import smecalculus.bezmen.domain.spec.Sepulka;
import smecalculus.bezmen.messaging.spec.SepulkaRegReq;
import smecalculus.bezmen.messaging.spec.SepulkaRegRes;

public class SepulkaFixtures {
    public static final String NAME = "foo";

    public static SepulkaRegReq sepulkaRegReqPojo() {
        return new SepulkaRegReq(NAME);
    }

    public static Sepulka.Builder sepulkaBuilder() {
        return Sepulka.builder().id(UUID.randomUUID()).name(NAME);
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
