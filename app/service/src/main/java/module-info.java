module bezmen.service  {
    exports org.smecalculus.bezmen.service.contract;
    exports org.smecalculus.bezmen.service;

    requires bezmen.core;
    requires bezmen.data;

    requires spring.context;

    requires lombok;
}
