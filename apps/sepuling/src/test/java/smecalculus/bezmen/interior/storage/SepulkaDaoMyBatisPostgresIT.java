package smecalculus.bezmen.interior.storage;

import org.springframework.test.context.ContextConfiguration;
import smecalculus.bezmen.interior.construction.MappingMyBatisBeans;
import smecalculus.bezmen.interior.construction.SepulkaDaoBeans;

@ContextConfiguration(classes = {SepulkaDaoBeans.MyBatisPostgres.class, MappingMyBatisBeans.class})
public class SepulkaDaoMyBatisPostgresIT extends SepulkaDaoIT {}
