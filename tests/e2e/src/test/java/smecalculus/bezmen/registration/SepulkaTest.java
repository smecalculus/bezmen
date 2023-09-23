package smecalculus.bezmen.registration;

import static java.time.Duration.ofSeconds;
import static org.assertj.core.api.Assertions.assertThat;
import static org.awaitility.Awaitility.await;
import static smecalculus.bezmen.messaging.client.SepulkaRegReqEg.Pojo.sepulkaRegReq;
import static smecalculus.bezmen.messaging.client.SepulkaRegResEg.Pojo.sepulkaRegRes;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfSystemProperty;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import smecalculus.bezmen.StandBeans;
import smecalculus.bezmen.messaging.client.BezmenClient;
import smecalculus.bezmen.messaging.client.SepulkaRegReq;
import smecalculus.bezmen.messaging.client.SepulkaRegRes;

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
        SepulkaRegReq request = sepulkaRegReq();
        // and
        SepulkaRegRes expectedResponse = sepulkaRegRes();
        // when
        SepulkaRegRes actualResponse = bezmenClient.register(request);
        // then
        assertThat(actualResponse)
                .usingRecursiveComparison()
                .ignoringFields("id")
                .isEqualTo(expectedResponse);
    }

    @Test
    @EnabledIfSystemProperty(named = "storage.vendor.mode", matches = "postgres")
    void postgresSpecificTest() {
        // empty
    }

    @Test
    @EnabledIfSystemProperty(named = "storage.vendor.mode", matches = "sqlite")
    void sqliteSpecificTest() {
        // empty
    }
}
