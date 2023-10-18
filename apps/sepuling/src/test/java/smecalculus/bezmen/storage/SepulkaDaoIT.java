package smecalculus.bezmen.storage;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import smecalculus.bezmen.construction.SepulkaDaoBeans;
import smecalculus.bezmen.core.ServerSideEg;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = SepulkaDaoBeans.class)
@Sql("/schemas/sepulkarium/truncate.sql")
abstract class SepulkaDaoIT {

    @Autowired
    private SepulkaDao sepulkaDao;

    @Test
    void shouldAddOneSepulka() {
        // given
        var expected1 = ServerSideEg.aggregateState().build();
        // and
        var expected2 =
                ServerSideEg.creationState().internalId(expected1.internalId()).build();
        // when
        var actualSaved = sepulkaDao.add(expected1);
        // and
        var actualSelected = sepulkaDao.getBy(expected1.externalId());
        // then
        assertThat(actualSaved)
                .usingRecursiveComparison()
                .isEqualTo(expected1);
        // and
        assertThat(actualSelected).contains(expected2)
                .usingRecursiveComparison();
    }

    @Test
    void shouldViewOneSepulka() {
        // given
        var aggregate = ServerSideEg.aggregateState().build();
        // and
        sepulkaDao.add(aggregate);
        // and
        var expected = ServerSideEg.previewState(aggregate).build();
        // when
        var actual = sepulkaDao.getBy(aggregate.internalId());
        // then
        assertThat(actual).contains(expected);
    }

    @Test
    void shouldUpdateOneSepulka() {
        // given
        var aggregate = ServerSideEg.aggregateState().build();
        // and
        sepulkaDao.add(aggregate);
        // and
        var updatedAt = aggregate.updatedAt().plusSeconds(1);
        // and
        var touch = ServerSideEg.touchState(aggregate)
                .updatedAt(updatedAt)
                .build();
        // when
        var updatedCount = sepulkaDao.updateBy(touch, aggregate.internalId());
        // then
        assertThat(updatedCount).isEqualTo(1);
    }
}
