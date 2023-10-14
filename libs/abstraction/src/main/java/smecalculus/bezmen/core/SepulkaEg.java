package smecalculus.bezmen.core;

import java.util.UUID;

public class SepulkaEg {
    public static class Pojos {
        public static Sepulka sepulka() {
            return Builders.sepulka().build();
        }

        public static Sepulka sepulka(UUID id) {
            return Builders.sepulka(id).build();
        }
    }

    public static class Builders {
        public static Sepulka.Builder sepulka() {
            return Sepulka.builder()
                    .internalId(UUID.randomUUID())
                    .externalId(UUID.randomUUID().toString());
        }

        public static Sepulka.Builder sepulka(UUID internalId) {
            return sepulka().internalId(internalId);
        }

        public static Sepulka.Builder sepulka(String externalId) {
            return sepulka().externalId(externalId);
        }
    }
}
