package smecalculus.bezmen.registration;

import static java.time.Duration.ofSeconds;
import static org.assertj.core.api.Assertions.assertThat;
import static org.awaitility.Awaitility.await;
import static smecalculus.bezmen.messaging.client.SepulkaRegisterSliceEg.Pojos.sepulkaRegisterSlice;

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
import smecalculus.bezmen.messaging.client.SepulkaRegisterSlice;
import smecalculus.bezmen.messaging.client.SepulkaRegisteredSlice;
import smecalculus.bezmen.messaging.client.SepulkaRegisteredSliceEg;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = StandBeans.class)
public class SepulkaTest {

    @Autowired
    private BezmenClient bezmenClient;

    @BeforeAll
    void beforeAll() {
        await("isReady").atMost(ofSeconds(5)).until(bezmenClient::isReady);
    }

    @Test
    @Tag("smoke")
    void shouldRegisterSepulka() {
        // given
        SepulkaRegisterSlice request = sepulkaRegisterSlice();
        // and
        SepulkaRegisteredSlice expectedResponse = SepulkaRegisteredSliceEg.Pojos.sepulkaRegisteredSlice();
        // when
        SepulkaRegisteredSlice actualResponse = bezmenClient.register(request);
        // then
        assertThat(actualResponse)
                .usingRecursiveComparison()
                .ignoringFields("id")
                .isEqualTo(expectedResponse);
    }

    @Test
    @EnabledIfSystemProperty(named = "storage.protocol.mode", matches = "postgres")
    void postgresSpecificTest() {
        // empty
    }

    @Test
    @EnabledIfSystemProperty(named = "storage.protocol.mode", matches = "sqlite")
    void sqliteSpecificTest() {
        // empty
    }
}
