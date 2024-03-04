package smecalculus.bezmen.core

import smecalculus.bezmen.core.SepulkaMessageDm.RegistrationRequest
import smecalculus.bezmen.core.SepulkaMessageDm.RegistrationResponse
import smecalculus.bezmen.core.SepulkaMessageDm.ViewRequest
import smecalculus.bezmen.core.SepulkaMessageDm.ViewResponse
import smecalculus.bezmen.storage.SepulkaDao
import java.time.LocalDateTime
import java.util.UUID

class SepulkaServiceImpl(
    private val converter: SepulkaConverter,
    private val dao: SepulkaDao,
) : SepulkaService {
    override fun register(request: RegistrationRequest): RegistrationResponse {
        val now = LocalDateTime.now()
        val sepulkaCreated =
            converter.toState(request)
                .internalId(UUID.randomUUID())
                .revision(0)
                .createdAt(now)
                .updatedAt(now)
                .build()
        val sepulkaSaved = dao.add(sepulkaCreated)
        return converter.toMessage(sepulkaSaved).build()
    }

    override fun view(request: ViewRequest): ViewResponse {
        return ViewResponse(request.externalId)
    }
}
