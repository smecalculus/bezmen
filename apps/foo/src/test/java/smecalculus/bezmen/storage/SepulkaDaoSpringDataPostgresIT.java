package smecalculus.bezmen.storage;

import org.springframework.test.context.ContextConfiguration;
import smecalculus.bezmen.construction.OrmSpringDataBeans;
import smecalculus.bezmen.construction.SepulkaDaoBeans;

@ContextConfiguration(classes = {SepulkaDaoBeans.SpringDataPostgres.class, OrmSpringDataBeans.class})
public class SepulkaDaoSpringDataPostgresIT extends SepulkaDaoIT {}
