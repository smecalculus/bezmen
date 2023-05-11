package org.smecalculus.bezmen.data;

import org.smecalculus.bezmen.construction.OrmSpringDataBeans;
import org.smecalculus.bezmen.construction.SepulkaDaoBeans;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = {SepulkaDaoBeans.SpringDataPostgres.class, OrmSpringDataBeans.class})
public class SepulkaDaoSpringDataPostgresIT extends SepulkaDaoIT {}
