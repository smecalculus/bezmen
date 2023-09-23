package smecalculus.bezmen.core;

import java.util.UUID;

public class SepulkaEg {
    public static final String NAME = "foo";

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
            return Sepulka.builder().id(UUID.randomUUID()).name(NAME);
        }

        public static Sepulka.Builder sepulka(UUID id) {
            return sepulka().id(id);
        }
    }
}
