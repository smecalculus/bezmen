package smecalculus.bezmen.messaging

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.ArgumentMatchers.any
import org.mockito.kotlin.whenever
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit.jupiter.SpringExtension
import smecalculus.bezmen.construction.SepulkaClientBeans
import smecalculus.bezmen.core.SepulkaMessageDm
import smecalculus.bezmen.core.SepulkaMessageDmEg
import smecalculus.bezmen.core.SepulkaService
import java.util.UUID

@ExtendWith(SpringExtension::class)
@ContextConfiguration(classes = [SepulkaClientBeans::class])
abstract class SepulkaClientIT {

    @Autowired
    private lateinit var externalClient: SepulkaClient

    @Autowired
    private lateinit var serviceMock: SepulkaService

    @Test
    fun shouldRegisterSepulka() {
        // given
        val externalId = UUID.randomUUID().toString()
        val internalId = UUID.randomUUID()
        // and
        val request = SepulkaMessageEmEg.registrationRequest(externalId)
        // and
        whenever(serviceMock.register(any(SepulkaMessageDm.RegistrationRequest::class.java)))
            .thenReturn(SepulkaMessageDmEg.registrationResponse(internalId).build())
        // and
        val expectedResponse = SepulkaMessageEmEg.registrationResponse(internalId.toString())
        // when
        val actualResponse = externalClient.register(request)
        // then
        assertThat(actualResponse)
            .usingRecursiveComparison()
            .ignoringExpectedNullFields()
            .isEqualTo(expectedResponse)
    }

    @Test
    fun shouldViewSepulka() {
        // given
        val internalId = UUID.randomUUID()
        val externalId = UUID.randomUUID().toString()
        // and
        val request = SepulkaMessageEmEg.viewingRequest(internalId.toString())
        // and
        whenever(serviceMock.view(any(SepulkaMessageDm.ViewingRequest::class.java)))
            .thenReturn(SepulkaMessageDmEg.viewingResponse(externalId).build())
        // and
        val expectedResponse = SepulkaMessageEmEg.viewingResponse(externalId)
        // when
        val actualResponse = externalClient.view(request)
        // then
        assertThat(actualResponse)
            .usingRecursiveComparison()
            .ignoringExpectedNullFields()
            .isEqualTo(expectedResponse)
    }
}
