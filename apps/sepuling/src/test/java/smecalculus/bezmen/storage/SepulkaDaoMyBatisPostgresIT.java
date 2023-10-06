package smecalculus.bezmen.storage;

import org.springframework.test.context.ContextConfiguration;
import smecalculus.bezmen.construction.MappingMyBatisBeans;
import smecalculus.bezmen.construction.SepulkaDaoBeans;

@ContextConfiguration(classes = {SepulkaDaoBeans.MyBatisPostgres.class, MappingMyBatisBeans.class})
public class SepulkaDaoMyBatisPostgresIT extends SepulkaDaoIT {}
