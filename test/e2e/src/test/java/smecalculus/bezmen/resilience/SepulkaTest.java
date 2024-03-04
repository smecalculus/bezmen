package smecalculus.bezmen.resilience;

import static java.time.Duration.ofSeconds;
import static org.assertj.core.api.Assertions.assertThat;
import static org.awaitility.Awaitility.await;
import static smecalculus.bezmen.messaging.SepulkaMessageEmEg.registrationRequest;
import static smecalculus.bezmen.messaging.SepulkaMessageEmEg.viewRequest;

import java.util.UUID;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import smecalculus.bezmen.messaging.BezmenClient;
import smecalculus.bezmen.messaging.SepulkaMessageEmEg;

public class SepulkaTest extends AbstractResilienceTest {

    @Autowired
    private BezmenClient bezmenClient;

    @BeforeAll
    void beforeAll() {
        await("isReady").atMost(ofSeconds(5)).until(bezmenClient::isReady);
    }

    @Test
    void shouldViewSepulka() {
        // given
        String externalId = UUID.randomUUID().toString();
        // and
        var registrationRequest = registrationRequest(externalId);
        // and
        bezmenClient.register(registrationRequest(externalId));
        // and
        demiurge.kills(postgresPrimary);
        // and
        var expectedResponse = SepulkaMessageEmEg.viewResponse(registrationRequest.getExternalId());
        // when
        var actualResponse = bezmenClient.view(viewRequest(externalId));
        // then
        assertThat(actualResponse).usingRecursiveComparison().isEqualTo(expectedResponse);
    }
}
