package smecalculus.bezmen.core;

import static java.util.UUID.randomUUID;

import java.time.LocalDateTime;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import smecalculus.bezmen.core.SepulkaMessageDm.RegistrationRequest;
import smecalculus.bezmen.core.SepulkaMessageDm.RegistrationResponse;
import smecalculus.bezmen.core.SepulkaMessageDm.ViewRequest;
import smecalculus.bezmen.core.SepulkaMessageDm.ViewResponse;
import smecalculus.bezmen.storage.SepulkaDao;

@RequiredArgsConstructor
public class SepulkaServiceImpl implements SepulkaService {

    @NonNull
    private SepulkaConverter converter;

    @NonNull
    private SepulkaDao dao;

    @Override
    public RegistrationResponse register(RegistrationRequest request) {
        var now = LocalDateTime.now();
        var sepulkaCreated = converter
                .toState(request)
                .internalId(randomUUID())
                .revision(0)
                .createdAt(now)
                .updatedAt(now)
                .build();
        var sepulkaSaved = dao.add(sepulkaCreated);
        return converter.toMessage(sepulkaSaved);
    }

    @Override
    public ViewResponse view(ViewRequest request) {
        var state = dao.getBy(request.internalId());
        return state.map(converter::toMessage).orElseThrow(RuntimeException::new);
    }
}
