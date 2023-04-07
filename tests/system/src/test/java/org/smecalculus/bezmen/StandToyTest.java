package org.smecalculus.bezmen;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.smecalculus.bezmen.client.BezmenClient;
import org.smecalculus.bezmen.client.SepulkaRegReq;
import org.smecalculus.bezmen.client.SepulkaRegRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static java.time.Duration.ofSeconds;
import static org.assertj.core.api.Assertions.assertThat;
import static org.awaitility.Awaitility.await;
import static org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS;
import static org.smecalculus.bezmen.fixture.SepulkaFixtures.sepulkaRegReqPojo;
import static org.smecalculus.bezmen.fixture.SepulkaFixtures.sepulkaRegResPojo;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = StandBeans.class)
@TestInstance(PER_CLASS)
public class StandToyTest {

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
}
