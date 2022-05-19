package org.smecalculus.bezmen.weighing.data;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.smecalculus.bezmen.weighing.service.Weighing;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.smecalculus.bezmen.weighing.service.WeighingFixtures.getWeighing;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = WeighingDaoBaseBeans.class)
abstract class WeighingDaoBaseTest {

    abstract WeighingDao underTest();

    private WeighingDao weighingDao;

    @BeforeEach
    void setUp() {
        weighingDao = underTest();
    }

    @Nested
    class Save {

        @Test
        void shouldSaveOneWeighing() {
            // given
            Weighing expectedWeighing = getWeighing().build();
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
}