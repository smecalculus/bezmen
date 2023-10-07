package smecalculus.bezmen.interior.storage;

import org.springframework.test.context.ContextConfiguration;
import smecalculus.bezmen.interior.construction.MappingSpringDataBeans;
import smecalculus.bezmen.interior.construction.SepulkaDaoBeans;

@ContextConfiguration(classes = {SepulkaDaoBeans.SpringDataPostgres.class, MappingSpringDataBeans.class})
public class SepulkaDaoSpringDataPostgresIT extends SepulkaDaoIT {}
