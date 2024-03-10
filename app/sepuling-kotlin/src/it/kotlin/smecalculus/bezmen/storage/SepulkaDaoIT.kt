package smecalculus.bezmen.storage

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.annotation.DirtiesContext
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit.jupiter.SpringExtension
import smecalculus.bezmen.construction.SepulkaDaoBeans
import smecalculus.bezmen.core.SepulkaStateDmEg

@DirtiesContext
@ExtendWith(SpringExtension::class)
@ContextConfiguration(classes = [SepulkaDaoBeans.Anyone::class])
abstract class SepulkaDaoIT {
    @Autowired
    private lateinit var sepulkaDao: SepulkaDao

    @Test
    fun shouldAddOneSepulka() {
        // given
        val expected1 = SepulkaStateDmEg.aggregateRoot().build()
        // and
        val expected2 = SepulkaStateDmEg.existence().internalId(expected1.internalId).build()
        // when
        val actualInserted = sepulkaDao.addNew(expected1)
        // and
        val actualSelected = sepulkaDao.getBy(expected1.externalId)
        // then
        assertThat(actualInserted).usingRecursiveComparison().isEqualTo(expected1)
        // and
        assertThat(actualSelected).usingRecursiveComparison().isEqualTo(expected2)
    }

    @Test
    fun shouldGetOneSepulka() {
        // given
        val aggregate = SepulkaStateDmEg.aggregateRoot().build()
        // and
        sepulkaDao.addNew(aggregate)
        // and
        val expected = SepulkaStateDmEg.viewing(aggregate).build()
        // when
        val actual = sepulkaDao.getBy(aggregate.internalId)
        // then
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun shouldTouchOneSepulka() {
        // given
        val aggregate = SepulkaStateDmEg.aggregateRoot().build()
        // and
        sepulkaDao.addNew(aggregate)
        // and
        val updatedAt = aggregate.updatedAt.plusSeconds(1)
        // and
        val touch = SepulkaStateDmEg.touch(aggregate).updatedAt(updatedAt).build()
        // when
        sepulkaDao.touchBy(aggregate.internalId, touch)
        // then
        // no exception
    }
}
