module bezmen.config {
    exports org.smecalculus.bezmen.config.data to
            bezmen.data;

    requires spring.context;

    requires lombok;
    requires org.mapstruct;
    requires java.compiler;
}
