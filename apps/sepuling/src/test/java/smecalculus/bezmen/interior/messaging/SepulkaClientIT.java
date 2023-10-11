package smecalculus.bezmen.interior.messaging;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static smecalculus.bezmen.exterior.messaging.SepulkaRegisterSliceEg.Pojos.sepulkaRegisterSliceMsg;
import static smecalculus.bezmen.exterior.messaging.SepulkaRegisteredSliceEg.Pojos.sepulkaRegisteredSlice;
import static smecalculus.bezmen.exterior.messaging.SepulkaRegisteredSliceEg.Pojos.sepulkaRegisteredSliceMsg;

import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import smecalculus.bezmen.exterior.messaging.SepulkaClient;
import smecalculus.bezmen.exterior.messaging.SepulkaRegisterSlice;
import smecalculus.bezmen.interior.construction.SepulkaClientBeans;
import smecalculus.bezmen.interior.core.SepulkaService;

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
        var id = UUID.randomUUID();
        // and
        var request = sepulkaRegisterSliceMsg();
        // and
        when(serviceMock.register(any(SepulkaRegisterSlice.class))).thenReturn(sepulkaRegisteredSlice(id));
        // and
        var expectedResponse = sepulkaRegisteredSliceMsg(id);
        // when
        var actualResponse = externalClient.register(request);
        // then
        assertThat(actualResponse)
                .usingRecursiveComparison()
                .ignoringExpectedNullFields()
                .isEqualTo(expectedResponse);
    }
}
