package org.smecalculus.bezmen.data;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.smecalculus.bezmen.modeling.Sepulka;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.sql.DataSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.smecalculus.bezmen.fixture.SepulkaFixtures.sepulkaBuilder;
import static org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType.H2;

@ContextConfiguration
@ExtendWith(SpringExtension.class)
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

    @Configuration
    static class Beans {
        @Bean
        public SepulkaRecMapper sepulkaRecMapper() {
            return new SepulkaRecMapperImpl();
        }

        @Bean
        public DataSource dataSource() {
            String settings = String.join(";",
                    "testdb",
                    "MODE=STRICT",
                    "DB_CLOSE_DELAY=-1",
                    "DATABASE_TO_LOWER=TRUE",
                    "DEFAULT_NULL_ORDERING=HIGH"
            );
            return new EmbeddedDatabaseBuilder()
                    .setType(H2)
                    .setName(settings)
                    .addScript("schemas/alfa/wipe.sql")
                    .addScript("schemas/alfa/schema.sql")
                    .build();
        }
    }
}