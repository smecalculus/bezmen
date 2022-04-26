module bezmen.data  {
    exports org.smecalculus.bezmen.data.contract;
    exports org.smecalculus.bezmen.data;

    requires bezmen.core;

    requires java.sql;

    requires spring.data.commons;
    requires spring.data.jdbc;
    requires spring.jdbc;
    requires spring.data.relational;
    requires spring.context;

    requires org.mybatis;

    requires lombok;
    requires org.mapstruct;
    requires java.compiler;
}
