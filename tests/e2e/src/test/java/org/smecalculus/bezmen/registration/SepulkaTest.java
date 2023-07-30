package org.smecalculus.bezmen.registration;

import static java.time.Duration.ofSeconds;
import static org.assertj.core.api.Assertions.assertThat;
import static org.awaitility.Awaitility.await;
import static org.smecalculus.bezmen.fixture.SepulkaFixtures.sepulkaRegReqPojo;
import static org.smecalculus.bezmen.fixture.SepulkaFixtures.sepulkaRegResPojo;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfSystemProperty;
import org.junit.jupiter.api.extension.ExtendWith;
import org.smecalculus.bezmen.StandBeans;
import org.smecalculus.bezmen.messaging.BezmenClient;
import org.smecalculus.bezmen.messaging.SepulkaRegReq;
import org.smecalculus.bezmen.messaging.SepulkaRegRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = StandBeans.class)
public class SepulkaTest {

    @Autowired
    private BezmenClient bezmenClient;

    @BeforeAll
    void beforeAll() {
        await().atMost(ofSeconds(5)).until(bezmenClient::isReady);
    }

    @Test
    @Tag("smoke")
    void shouldRegisterSepulka() {
        // given
        SepulkaRegReq request = sepulkaRegReqPojo();
        // and
        SepulkaRegRes expectedResponse = sepulkaRegResPojo();
        // when
        SepulkaRegRes actualResponse = bezmenClient.register(request);
        // then
        assertThat(actualResponse)
                .usingRecursiveComparison()
                .ignoringFields("id")
                .isEqualTo(expectedResponse);
    }

    @Test
    @EnabledIfSystemProperty(named = "data.vendor.mode", matches = "postgres")
    void postgresSpecificTest() {
        // empty
    }

    @Test
    @EnabledIfSystemProperty(named = "data.vendor.mode", matches = "sqlite")
    void sqliteSpecificTest() {
        // empty
    }
}
