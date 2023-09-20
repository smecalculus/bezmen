package smecalculus.bezmen.data.impl;

import org.springframework.test.context.ContextConfiguration;
import smecalculus.bezmen.construction.spec.OrmMyBatisBeans;
import smecalculus.bezmen.construction.spec.SepulkaDaoBeans;

@ContextConfiguration(classes = {SepulkaDaoBeans.MyBatisPostgres.class, OrmMyBatisBeans.class})
public class SepulkaDaoMyBatisPostgresIT extends SepulkaDaoIT {}
