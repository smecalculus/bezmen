package smecalculus.bezmen.core

import smecalculus.bezmen.core.SepulkaMessageDm.RegistrationRequest
import smecalculus.bezmen.core.SepulkaMessageDm.RegistrationResponse
import smecalculus.bezmen.core.SepulkaMessageDm.ViewingRequest
import smecalculus.bezmen.core.SepulkaMessageDm.ViewingResponse
import smecalculus.bezmen.storage.SepulkaDao
import java.time.LocalDateTime
import java.util.UUID

class SepulkaServiceImpl(
    private val factory: SepulkaFactory,
    private val dao: SepulkaDao,
) : SepulkaService {
    override fun register(request: RegistrationRequest): RegistrationResponse {
        val now = LocalDateTime.now()
        val stateCreated =
            factory.newState(request)
                .internalId(UUID.randomUUID())
                .revision(0)
                .createdAt(now)
                .updatedAt(now)
                .build()
        val statePersisted = dao.addNew(stateCreated)
        return factory.newMessage(statePersisted)
    }

    override fun view(request: ViewingRequest): ViewingResponse {
        val state = dao.getBy(request.internalId)
        return state?.let { factory.newMessage(it) } ?: throw RuntimeException()
    }
}
