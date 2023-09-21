package smecalculus.bezmen.storage;

import org.springframework.test.context.ContextConfiguration;
import smecalculus.bezmen.construction.OrmMyBatisBeans;
import smecalculus.bezmen.construction.SepulkaDaoBeans;

@ContextConfiguration(classes = {SepulkaDaoBeans.MyBatisPostgres.class, OrmMyBatisBeans.class})
public class SepulkaDaoMyBatisPostgresIT extends SepulkaDaoIT {}
