package smecalculus.bezmen.data.impl;

import org.springframework.test.context.ContextConfiguration;
import smecalculus.bezmen.construction.spec.OrmSpringDataBeans;
import smecalculus.bezmen.construction.spec.SepulkaDaoBeans;

@ContextConfiguration(classes = {SepulkaDaoBeans.SpringDataPostgres.class, OrmSpringDataBeans.class})
public class SepulkaDaoSpringDataPostgresIT extends SepulkaDaoIT {}
