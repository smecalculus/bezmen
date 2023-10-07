package smecalculus.bezmen.interior.storage;

import static org.assertj.core.api.Assertions.assertThat;
import static smecalculus.bezmen.interior.core.SepulkaEg.Pojos.sepulka;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import smecalculus.bezmen.interior.construction.SepulkaDaoBeans;
import smecalculus.bezmen.interior.core.Sepulka;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = SepulkaDaoBeans.class)
@Sql("/schemas/sepulkarium/truncate.sql")
abstract class SepulkaDaoIT {

    @Autowired
    private SepulkaDao sepulkaDao;

    @Test
    void shouldSaveOneSepulka() {
        // given
        Sepulka expectedSepulka = sepulka();
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
