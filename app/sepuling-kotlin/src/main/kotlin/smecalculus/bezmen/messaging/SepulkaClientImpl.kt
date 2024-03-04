package smecalculus.bezmen.messaging

import smecalculus.bezmen.core.SepulkaService
import smecalculus.bezmen.messaging.SepulkaMessageEm.RegistrationRequest
import smecalculus.bezmen.messaging.SepulkaMessageEm.RegistrationResponse
import smecalculus.bezmen.messaging.SepulkaMessageEm.ViewRequest
import smecalculus.bezmen.messaging.SepulkaMessageEm.ViewResponse
import smecalculus.bezmen.validation.EdgeValidator

class SepulkaClientImpl(
    private val validator: EdgeValidator,
    private val mapper: SepulkaMessageMapper,
    private val service: SepulkaService,
) : SepulkaClient {
    override fun register(requestEdge: RegistrationRequest): RegistrationResponse {
        validator.validate(requestEdge)
        val request = mapper.toDomain(requestEdge)
        val response = service.register(request)
        return mapper.toEdge(response)
    }

    override fun view(requestEdge: ViewRequest): ViewResponse {
        validator.validate(requestEdge)
        val request = mapper.toDomain(requestEdge)
        val response = service.view(request)
        return mapper.toEdge(response)
    }
}
