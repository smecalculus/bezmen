package org.smecalculus.bezmen.data;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.smecalculus.bezmen.construction.SepulkaDaoBeans;
import org.smecalculus.bezmen.modeling.Sepulka;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.smecalculus.bezmen.fixture.SepulkaFixtures.sepulkaBuilder;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = SepulkaDaoBeans.class)
abstract class SepulkaDaoIT {

    @Autowired
    private SepulkaDao sepulkaDao;

    @Test
    void shouldSaveOneSepulka() {
        // given
        Sepulka expectedSepulka = sepulkaBuilder().build();
        // when
        Sepulka actualSepulka1 = sepulkaDao.save(expectedSepulka);
        // and
        Sepulka actualSepulka2 = sepulkaDao.getById(expectedSepulka.id());
        // then
        assertThat(actualSepulka1).isEqualTo(expectedSepulka);
        // and
        assertThat(actualSepulka2).isEqualTo(expectedSepulka);
    }
}