package smecalculus.bezmen.messaging;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static smecalculus.bezmen.core.SepulkaNewResponseEg.Pojos.sepulkaNewResponse;
import static smecalculus.bezmen.messaging.SepulkaNewRequestEg.Pojos.sepulkaNewRequestEdge;
import static smecalculus.bezmen.messaging.SepulkaNewResponseEg.Pojos.sepulkaNewResponseEdge;

import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import smecalculus.bezmen.construction.SepulkaClientBeans;
import smecalculus.bezmen.core.SepulkaNewRequest;
import smecalculus.bezmen.core.SepulkaService;

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
        var externalId = UUID.randomUUID().toString();
        // and
        var request = sepulkaNewRequestEdge(externalId);
        // and
        when(serviceMock.register(any(SepulkaNewRequest.class))).thenReturn(sepulkaNewResponse(externalId));
        // and
        var expectedResponse = sepulkaNewResponseEdge(externalId);
        // when
        var actualResponse = externalClient.register(request);
        // then
        assertThat(actualResponse)
                .usingRecursiveComparison()
                .ignoringExpectedNullFields()
                .isEqualTo(expectedResponse);
    }
}
