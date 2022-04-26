module bezmen.data  {
    exports org.smecalculus.bezmen.data.contract;
    exports org.smecalculus.bezmen.data;

    requires bezmen.core;

    requires spring.data.commons;
    requires spring.data.jdbc;
    requires spring.context;

    requires org.mybatis;

    requires lombok;
    requires org.mapstruct;
    requires java.compiler;
}
