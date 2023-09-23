package smecalculus.bezmen.core;

import java.util.UUID;

public class SepulkaEg {
    public static final String NAME = "foo";

    public static class Pojo {
        public static Sepulka sepulka() {
            return Template.sepulka().build();
        }

        public static Sepulka sepulka(UUID id) {
            return Template.sepulka(id).build();
        }
    }

    public static class Template {
        public static Sepulka.Builder sepulka() {
            return Sepulka.builder().id(UUID.randomUUID()).name(NAME);
        }

        public static Sepulka.Builder sepulka(UUID id) {
            return sepulka().id(id);
        }
    }
}
