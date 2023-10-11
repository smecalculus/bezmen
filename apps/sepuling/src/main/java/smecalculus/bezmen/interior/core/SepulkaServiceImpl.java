package smecalculus.bezmen.interior.core;

import static java.util.UUID.randomUUID;

import java.util.List;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import smecalculus.bezmen.exterior.messaging.SepulkaRegisterSlice;
import smecalculus.bezmen.exterior.messaging.SepulkaRegisteredSlice;
import smecalculus.bezmen.interior.storage.SepulkaDao;

@RequiredArgsConstructor
public class SepulkaServiceImpl implements SepulkaService {

    @NonNull
    private SepulkaSliceMapper mapper;

    @NonNull
    private SepulkaDao dao;

    @Override
    public SepulkaRegisteredSlice register(SepulkaRegisterSlice request) {
        var sepulkaCreated = mapper.toDomain(request).id(randomUUID()).build();
        var sepulkaSaved = dao.save(sepulkaCreated);
        return mapper.toSlice(sepulkaSaved);
    }

    @Override
    public List<Sepulka> getSepulkas() {
        return dao.getSepulkas();
    }
}
