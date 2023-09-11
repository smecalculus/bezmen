package org.smecalculus.bezmen.data.impl;

import org.smecalculus.bezmen.construction.spec.OrmSpringDataBeans;
import org.smecalculus.bezmen.construction.spec.SepulkaDaoBeans;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = {SepulkaDaoBeans.SpringDataPostgres.class, OrmSpringDataBeans.class})
public class SepulkaDaoSpringDataPostgresIT extends SepulkaDaoIT {}
