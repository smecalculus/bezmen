package smecalculus.bezmen.messaging.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static smecalculus.bezmen.fixture.SepulkaFixtures.sepulkaPojo;
import static smecalculus.bezmen.fixture.SepulkaFixtures.sepulkaRegReqPojo;
import static smecalculus.bezmen.fixture.SepulkaFixtures.sepulkaRegResPojo;

import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import smecalculus.bezmen.construction.spec.SepulkaClientBeans;
import smecalculus.bezmen.domain.spec.SepulkaService;
import smecalculus.bezmen.messaging.spec.SepulkaClient;
import smecalculus.bezmen.messaging.spec.SepulkaRegReq;
import smecalculus.bezmen.messaging.spec.SepulkaRegRes;

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
