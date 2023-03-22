package org.smecalculus.bezmen.foo.data;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.smecalculus.bezmen.foo.data.beans.SepulkaDaoBeans;
import org.smecalculus.bezmen.foo.fixtures.SepulkaFixtures;
import org.smecalculus.bezmen.foo.service.Sepulka;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = SepulkaDaoBeans.class)
abstract class SepulkaDaoIT {

    @Autowired
    private SepulkaDao sepulkaDao;

    @Test
    void shouldSaveOneSepulka() {
        // given
        Sepulka expectedSepulka = SepulkaFixtures.newSepulka().build();
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