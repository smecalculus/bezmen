package org.smecalculus.bezmen.data;

import org.smecalculus.bezmen.construction.OrmMyBatisBeans;
import org.smecalculus.bezmen.construction.SepulkaDaoBeans;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = {SepulkaDaoBeans.MyBatisPostgres.class, OrmMyBatisBeans.class})
public class SepulkaDaoMyBatisPostgresIT extends SepulkaDaoIT {}
