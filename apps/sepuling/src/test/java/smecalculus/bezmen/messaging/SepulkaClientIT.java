package smecalculus.bezmen.messaging;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static smecalculus.bezmen.core.SepulkaEg.Pojos.sepulka;
import static smecalculus.bezmen.messaging.client.SepulkaRegisterSliceEg.Pojos.sepulkaRegisterSlice;
import static smecalculus.bezmen.messaging.client.SepulkaRegisteredSliceEg.Pojos.sepulkaRegisteredSlice;

import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import smecalculus.bezmen.construction.SepulkaClientBeans;
import smecalculus.bezmen.core.SepulkaService;
import smecalculus.bezmen.messaging.client.SepulkaClient;
import smecalculus.bezmen.messaging.client.SepulkaRegisterSlice;
import smecalculus.bezmen.messaging.client.SepulkaRegisteredSlice;

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
        SepulkaRegisterSlice command = sepulkaRegisterSlice();
        // and
        when(serviceMock.register(any(SepulkaRegisterSlice.class))).thenReturn(sepulka(id));
        // and
        SepulkaRegisteredSlice expectedResponse = sepulkaRegisteredSlice(id);
        // when
        SepulkaRegisteredSlice actualResponse = externalClient.register(command);
        // then
        assertThat(actualResponse)
                .usingRecursiveComparison()
                .ignoringExpectedNullFields()
                .isEqualTo(expectedResponse);
    }
}
