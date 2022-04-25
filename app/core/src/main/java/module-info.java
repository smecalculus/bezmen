module bezmen.core  {
    exports org.smecalculus.bezmen.core.weighing;
    exports org.smecalculus.bezmen.core;

    requires bezmen.api;

    requires java.compiler;

    requires lombok;
    requires org.mapstruct;

    requires spring.context;
}
