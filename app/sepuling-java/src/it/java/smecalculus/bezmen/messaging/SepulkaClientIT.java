package smecalculus.bezmen.messaging;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import smecalculus.bezmen.construction.SepulkaClientBeans;
import smecalculus.bezmen.core.SepulkaMessageDm;
import smecalculus.bezmen.core.SepulkaMessageDm.RegistrationRequest;
import smecalculus.bezmen.core.SepulkaMessageDmEg;
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
        var internalId = UUID.randomUUID();
        // and
        var request = SepulkaMessageEmEg.registrationRequest(externalId);
        // and
        when(serviceMock.register(any(RegistrationRequest.class)))
                .thenReturn(SepulkaMessageDmEg.registrationResponse(internalId).build());
        // and
        var expectedResponse = SepulkaMessageEmEg.registrationResponse(internalId.toString());
        // when
        var actualResponse = externalClient.register(request);
        // then
        assertThat(actualResponse)
                .usingRecursiveComparison()
                .ignoringExpectedNullFields()
                .isEqualTo(expectedResponse);
    }

    @Test
    void shouldViewSepulka() {
        // given
        var internalId = UUID.randomUUID();
        var externalId = UUID.randomUUID().toString();
        // and
        var request = SepulkaMessageEmEg.viewRequest(internalId.toString());
        // and
        when(serviceMock.view(any(SepulkaMessageDm.ViewRequest.class)))
                .thenReturn(SepulkaMessageDmEg.viewResponse(externalId).build());
        // and
        var expectedResponse = SepulkaMessageEmEg.viewResponse(externalId);
        // when
        var actualResponse = externalClient.view(request);
        // then
        assertThat(actualResponse)
                .usingRecursiveComparison()
                .ignoringExpectedNullFields()
                .isEqualTo(expectedResponse);
    }
}
