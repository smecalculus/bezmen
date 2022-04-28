module bezmen.core  {
    exports org.smecalculus.bezmen.core.service to
            bezmen.web,
            bezmen.service,
            bezmen.data;

    requires lombok;
}
