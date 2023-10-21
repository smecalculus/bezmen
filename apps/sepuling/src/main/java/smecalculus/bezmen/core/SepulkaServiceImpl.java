package smecalculus.bezmen.core;

import static java.util.UUID.randomUUID;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import smecalculus.bezmen.core.ClientSide.PreviewRequest;
import smecalculus.bezmen.core.ClientSide.PreviewResponse;
import smecalculus.bezmen.core.ClientSide.RegistrationRequest;
import smecalculus.bezmen.core.ClientSide.RegistrationResponse;
import smecalculus.bezmen.storage.SepulkaDao;

@RequiredArgsConstructor
public class SepulkaServiceImpl implements SepulkaService {

    @NonNull
    private SepulkaSliceMapper mapper;

    @NonNull
    private SepulkaDao dao;

    @Override
    public RegistrationResponse register(RegistrationRequest request) {
        var now = LocalDateTime.now();
        var sepulkaCreated = mapper.toServer(request)
                .internalId(randomUUID())
                .revision(0)
                .createdAt(now)
                .updatedAt(now)
                .build();
        var sepulkaSaved = dao.add(sepulkaCreated);
        return mapper.toClient(sepulkaSaved).build();
    }

    @Override
    public List<PreviewResponse> view(PreviewRequest request) {
        return Collections.emptyList();
    }
}
