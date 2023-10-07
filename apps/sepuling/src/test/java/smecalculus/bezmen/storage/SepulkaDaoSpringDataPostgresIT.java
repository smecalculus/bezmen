package smecalculus.bezmen.storage;

import org.springframework.test.context.ContextConfiguration;
import smecalculus.bezmen.construction.MappingSpringDataBeans;
import smecalculus.bezmen.construction.SepulkaDaoBeans;

@ContextConfiguration(classes = {SepulkaDaoBeans.SpringDataPostgres.class, MappingSpringDataBeans.class})
public class SepulkaDaoSpringDataPostgresIT extends SepulkaDaoIT {}
