package smecalculus.bezmen.core

import smecalculus.bezmen.core.SepulkaMessageDm.RegistrationRequest
import smecalculus.bezmen.core.SepulkaMessageDm.RegistrationResponse
import smecalculus.bezmen.core.SepulkaMessageDm.ViewingRequest
import smecalculus.bezmen.core.SepulkaMessageDm.ViewingResponse
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
        val sepulkaSaved = dao.addNew(sepulkaCreated)
        return converter.toMessage(sepulkaSaved)
    }

    override fun view(request: ViewingRequest): ViewingResponse {
        val state = dao.getBy(request.internalId)
        return state?.let { converter.toMessage(it) } ?: throw RuntimeException()
    }
}
