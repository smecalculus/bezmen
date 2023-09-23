package smecalculus.bezmen.messaging;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static smecalculus.bezmen.core.SepulkaEg.Pojo.sepulka;
import static smecalculus.bezmen.messaging.client.SepulkaRegReqEg.Pojo.sepulkaRegReq;
import static smecalculus.bezmen.messaging.client.SepulkaRegResEg.Pojo.sepulkaRegRes;

import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import smecalculus.bezmen.construction.SepulkaClientBeans;
import smecalculus.bezmen.core.SepulkaService;
import smecalculus.bezmen.messaging.client.SepulkaClient;
import smecalculus.bezmen.messaging.client.SepulkaRegReq;
import smecalculus.bezmen.messaging.client.SepulkaRegRes;

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
        SepulkaRegReq request = sepulkaRegReq();
        // and
        when(serviceMock.register(any(SepulkaRegReq.class))).thenReturn(sepulka(id));
        // and
        SepulkaRegRes expectedResponse = sepulkaRegRes(id);
        // when
        SepulkaRegRes actualResponse = externalClient.register(request);
        // then
        assertThat(actualResponse)
                .usingRecursiveComparison()
                .ignoringExpectedNullFields()
                .isEqualTo(expectedResponse);
    }
}
