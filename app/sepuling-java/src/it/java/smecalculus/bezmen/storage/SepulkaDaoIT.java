package smecalculus.bezmen.storage;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import smecalculus.bezmen.construction.SepulkaDaoBeans;
import smecalculus.bezmen.core.SepulkaStateDmEg;

@DirtiesContext
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = SepulkaDaoBeans.Anyone.class)
abstract class SepulkaDaoIT {

    @Autowired
    private SepulkaDao sepulkaDao;

    @Test
    void shouldAddOneSepulka() {
        // given
        var expected1 = SepulkaStateDmEg.aggregateRoot().build();
        // and
        var expected2 =
                SepulkaStateDmEg.existence().internalId(expected1.internalId()).build();
        // when
        var actualInserted = sepulkaDao.addNew(expected1);
        // and
        var actualSelected = sepulkaDao.getBy(expected1.externalId());
        // then
        assertThat(actualInserted).usingRecursiveComparison().isEqualTo(expected1);
        // and
        assertThat(actualSelected).contains(expected2);
    }

    @Test
    void shouldGetOneSepulka() {
        // given
        var aggregate = SepulkaStateDmEg.aggregateRoot().build();
        // and
        sepulkaDao.addNew(aggregate);
        // and
        var expected = SepulkaStateDmEg.viewing(aggregate).build();
        // when
        var actual = sepulkaDao.getBy(aggregate.internalId());
        // then
        assertThat(actual).contains(expected);
    }

    @Test
    void shouldTouchOneSepulka() {
        // given
        var aggregate = SepulkaStateDmEg.aggregateRoot().build();
        // and
        sepulkaDao.addNew(aggregate);
        // and
        var updatedAt = aggregate.updatedAt().plusSeconds(1);
        // and
        var touch = SepulkaStateDmEg.touch(aggregate).updatedAt(updatedAt).build();
        // when
        sepulkaDao.touchBy(aggregate.internalId(), touch);
        // then
        // no exception
    }
}
