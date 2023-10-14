package smecalculus.bezmen.core;

import static java.util.UUID.randomUUID;

import java.util.List;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import smecalculus.bezmen.storage.SepulkaDao;

@RequiredArgsConstructor
public class SepulkaServiceImpl implements SepulkaService {

    @NonNull
    private SepulkaSliceMapper mapper;

    @NonNull
    private SepulkaDao dao;

    @Override
    public SepulkaNewResponse register(SepulkaNewRequest request) {
        var sepulkaCreated = mapper.toEntity(request).id(randomUUID()).build();
        var sepulkaSaved = dao.save(sepulkaCreated);
        return mapper.toSlice(sepulkaSaved);
    }

    @Override
    public List<Sepulka> getSepulkas() {
        return dao.getSepulkas();
    }
}
