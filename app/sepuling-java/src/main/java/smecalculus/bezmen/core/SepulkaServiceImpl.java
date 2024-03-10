package smecalculus.bezmen.core;

import static java.util.UUID.randomUUID;

import java.time.LocalDateTime;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import smecalculus.bezmen.core.SepulkaMessageDm.RegistrationRequest;
import smecalculus.bezmen.core.SepulkaMessageDm.RegistrationResponse;
import smecalculus.bezmen.core.SepulkaMessageDm.ViewingResponse;
import smecalculus.bezmen.storage.SepulkaDao;

@RequiredArgsConstructor
public class SepulkaServiceImpl implements SepulkaService {

    private static final Logger LOG = LoggerFactory.getLogger(SepulkaServiceImpl.class);

    @NonNull
    private SepulkaFactory factory;

    @NonNull
    private SepulkaDao dao;

    @Override
    public RegistrationResponse register(RegistrationRequest request) {
        LOG.debug("Handling sepulka registration request: {}", request);
        var now = LocalDateTime.now();
        var stateCreated = factory.newState(request)
                .internalId(randomUUID())
                .revision(0)
                .createdAt(now)
                .updatedAt(now)
                .build();
        var statePersisted = dao.addNew(stateCreated);
        return factory.newMessage(statePersisted);
    }

    @Override
    public ViewingResponse view(SepulkaMessageDm.ViewingRequest request) {
        LOG.debug("Handling sepulka viewing request: {}", request);
        var state = dao.getBy(request.internalId());
        return state.map(factory::newMessage).orElseThrow(RuntimeException::new);
    }
}
