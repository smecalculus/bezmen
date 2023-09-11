package org.smecalculus.bezmen.data.impl;

import org.smecalculus.bezmen.construction.spec.OrmMyBatisBeans;
import org.smecalculus.bezmen.construction.spec.SepulkaDaoBeans;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = {SepulkaDaoBeans.MyBatisPostgres.class, OrmMyBatisBeans.class})
public class SepulkaDaoMyBatisPostgresIT extends SepulkaDaoIT {}
