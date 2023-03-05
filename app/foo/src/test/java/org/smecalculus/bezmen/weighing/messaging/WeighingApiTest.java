package org.smecalculus.bezmen.weighing.messaging;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.smecalculus.bezmen.api.WeighingErrorRm;
import org.smecalculus.bezmen.api.WeighingSpecRm;
import org.smecalculus.bezmen.weighing.fixtures.WeighingFixtures;
import org.smecalculus.bezmen.weighing.messaging.harness.WeighingClient;
import org.smecalculus.bezmen.weighing.messaging.harness.WeighingRequest;
import org.smecalculus.bezmen.weighing.messaging.harness.WeighingResponse;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.smecalculus.bezmen.weighing.fixtures.WeighingFixtures.*;

@ExtendWith(MockitoExtension.class)
abstract class WeighingApiTest {

    protected WeighingClient weighingClient;

    @Mock
    private WeighingApi weighingApi;

    @BeforeEach
    void setUp() {
        setupClient(weighingApi);
    }

    abstract void setupClient(WeighingApi weighingApi);

    @Test
    void shouldRegisterOneWeighing() {
        // given
        WeighingRequest<WeighingSpecRm, Void> request = WeighingFixtures.<WeighingSpecRm, Void>newWeighingRequest(Void.class)
                .body(newWeighingSpecRm())
                .build();
        // and
        WeighingResponse<Void> expectedResponse = WeighingFixtures.<Void>newWeighingResponse()
                .body(null)
                .build();
        // and
        when(weighingApi.register(any(WeighingSpecRm.class))).thenReturn(newWeighingRm());
        // when
        WeighingResponse<Void> actualResponse = weighingClient.send(request);
        // then
        assertThat(actualResponse)
                .usingRecursiveComparison()
                .ignoringExpectedNullFields()
                .isEqualTo(expectedResponse);
    }

    @Test
    void shouldReturnServerError() {
        // given
        RuntimeException exception = new RuntimeException("something went wrong");
        // and
        when(weighingApi.register(any(WeighingSpecRm.class))).thenThrow(exception);
        // and
        WeighingResponse<WeighingErrorRm> expectedResponse = WeighingFixtures.<WeighingErrorRm>newWeighingResponse()
                .body(newWeighingErrorRm("something went wrong"))
                .build();
        // when
        WeighingResponse<WeighingErrorRm> actualResponse = weighingClient.send(
                newWeighingRequest(WeighingErrorRm.class)
                        .body(newWeighingSpecRm())
                        .build());
        // then
        assertThat(actualResponse)
                .usingRecursiveComparison()
                .ignoringExpectedNullFields()
                .isEqualTo(expectedResponse);
    }
}