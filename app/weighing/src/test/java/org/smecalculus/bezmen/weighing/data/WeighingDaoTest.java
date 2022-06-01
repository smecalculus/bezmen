package org.smecalculus.bezmen.weighing.data;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.smecalculus.bezmen.weighing.data.beans.WeighingDaoBeans;
import org.smecalculus.bezmen.weighing.service.Weighing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.smecalculus.bezmen.weighing.fixtures.WeighingFixtures.newWeighing;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = WeighingDaoBeans.class)
abstract class WeighingDaoTest {

    @Autowired
    private WeighingDao weighingDao;

    @Test
    void shouldSaveOneWeighing() {
        // given
        Weighing expectedWeighing = newWeighing().build();
        // when
        Weighing actualWeighing1 = weighingDao.save(expectedWeighing);
        // and
        Weighing actualWeighing2 = weighingDao.getById(expectedWeighing.id());
        // then
        assertThat(actualWeighing1).isEqualTo(expectedWeighing);
        // and
        assertThat(actualWeighing2).isEqualTo(expectedWeighing);
    }
}