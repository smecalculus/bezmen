package org.smecalculus.bezmen.foo.messaging;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.smecalculus.bezmen.client.SepulkaClient;
import org.smecalculus.bezmen.client.SepulkaRegReq;
import org.smecalculus.bezmen.client.SepulkaRegRes;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.smecalculus.bezmen.foo.fixtures.SepulkaFixtures.newSepulkaRegReq;
import static org.smecalculus.bezmen.foo.fixtures.SepulkaFixtures.newSepulkaRegRes;

@ExtendWith(MockitoExtension.class)
abstract class SepulkaClientIT {

    protected SepulkaClient webClient;

    @Mock
    private SepulkaClient appClient;

    @BeforeEach
    void setUp() {
        setupClient(appClient);
    }

    abstract void setupClient(SepulkaClient sepulkaClient);

    @Test
    void shouldRegisterOneSepulka() {
        // given
        SepulkaRegReq request = newSepulkaRegReq();
        // and
        SepulkaRegRes expectedResponse = newSepulkaRegRes();
        // and
        when(appClient.register(any(SepulkaRegReq.class))).thenReturn(newSepulkaRegRes());
        // when
        SepulkaRegRes actualResponse = webClient.register(request);
        // then
        assertThat(actualResponse)
                .usingRecursiveComparison()
                .ignoringExpectedNullFields()
                .isEqualTo(expectedResponse);
    }
}