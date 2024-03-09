package smecalculus.bezmen.resilience;

import static java.time.Duration.ofSeconds;
import static org.assertj.core.api.Assertions.assertThat;
import static org.awaitility.Awaitility.await;
import static smecalculus.bezmen.messaging.SepulkaMessageEmEg.registrationRequest;
import static smecalculus.bezmen.messaging.SepulkaMessageEmEg.viewRequest;

import java.util.UUID;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import smecalculus.bezmen.messaging.SepulkaMessageEmEg;

public class StorageResilienceTest extends AbstractResilienceTest {

    @BeforeAll
    void beforeAll() {
        demiurge.starts(services.get(POSTGRES_PRIMARY));
        await("isReady").atMost(ofSeconds(5)).until(bezmenClient::isReady);
    }

    @Test
    void shouldViewSepulka() {
        // given
        String externalId = UUID.randomUUID().toString();
        // and
        var registrationResponse = bezmenClient.register(registrationRequest(externalId));
        // and
        demiurge.kills(services.get(POSTGRES_PRIMARY));
        // and
        var expectedResponse = SepulkaMessageEmEg.viewResponse(externalId);
        // when
        var actualResponse = bezmenClient.view(viewRequest(registrationResponse.getInternalId()));
        // then
        assertThat(actualResponse).usingRecursiveComparison().isEqualTo(expectedResponse);
    }
}
