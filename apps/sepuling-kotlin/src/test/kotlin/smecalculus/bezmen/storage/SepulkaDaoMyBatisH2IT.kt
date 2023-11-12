package smecalculus.bezmen.storage

import org.springframework.test.context.ContextConfiguration
import smecalculus.bezmen.construction.SepulkaDaoBeans
import smecalculus.bezmen.construction.StoragePropsBeans

@ContextConfiguration(classes = [StoragePropsBeans.MyBatisH2::class, SepulkaDaoBeans.MyBatis::class])
class SepulkaDaoMyBatisH2IT : SepulkaDaoIT()
