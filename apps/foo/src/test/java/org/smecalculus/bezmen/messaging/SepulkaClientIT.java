package org.smecalculus.bezmen.messaging;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.smecalculus.bezmen.client.SepulkaClient;
import org.smecalculus.bezmen.client.SepulkaRegReq;
import org.smecalculus.bezmen.client.SepulkaRegRes;
import org.smecalculus.bezmen.domain.SepulkaService;
import org.smecalculus.bezmen.messaging.beans.SepulkaClientBeans;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.smecalculus.bezmen.fixture.SepulkaFixtures.sepulkaPojo;
import static org.smecalculus.bezmen.fixture.SepulkaFixtures.sepulkaRegReqPojo;
import static org.smecalculus.bezmen.fixture.SepulkaFixtures.sepulkaRegResPojo;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = SepulkaClientBeans.class)
abstract class SepulkaClientIT {

    @Autowired
    protected SepulkaClient externalClient;

    @Autowired
    private SepulkaService serviceMock;

    @Test
    void shouldRegisterSepulka() {
        // given
        UUID id = UUID.randomUUID();
        // and
        SepulkaRegReq request = sepulkaRegReqPojo();
        // and
        when(serviceMock.register(any(SepulkaRegReq.class))).thenReturn(sepulkaPojo(id));
        // and
        SepulkaRegRes expectedResponse = sepulkaRegResPojo(id);
        // when
        SepulkaRegRes actualResponse = externalClient.register(request);
        // then
        assertThat(actualResponse)
                .usingRecursiveComparison()
                .ignoringExpectedNullFields()
                .isEqualTo(expectedResponse);
    }
}