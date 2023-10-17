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
        var expected1 = ServerSideEg.storageState().build();
        // and
        var expected2 =
                ServerSideEg.creationState().internalId(expected1.internalId()).build();
        // when
        var actual1 = sepulkaDao.add(expected1);
        // and
        var actual2 = sepulkaDao.getBy(expected1.externalId());
        // then
        assertThat(actual1).isEqualTo(expected1);
        // and
        assertThat(actual2).contains(expected2);
    }

    @Test
    void shouldUpdateOneSepulka() {
        // given

        // when

        // then
    }
}
