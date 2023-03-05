package org.smecalculus.bezmen.weighing.data;

import lombok.NonNull;
import org.smecalculus.bezmen.weighing.WeighingModelMapper;
import org.smecalculus.bezmen.weighing.data.mybatis.WeighingSqlMapper;
import org.smecalculus.bezmen.weighing.service.Weighing;

import java.util.List;
import java.util.UUID;

import static java.util.Collections.emptyList;

public record WeighingDaoMyBatisImpl(
        @NonNull WeighingModelMapper mapper,
        @NonNull WeighingSqlMapper sqlMapper
) implements WeighingDao {

    @Override
    public Weighing getById(@NonNull UUID id) {
        return sqlMapper.findById(id.toString())
                .map(mapper::from)
                .orElse(null);
    }

    @Override
    public Weighing save(@NonNull Weighing weighing) {
        WeighingDm newWeighingDm = mapper.toDm(weighing);
        sqlMapper.insert(newWeighingDm);
        return weighing;
    }

    @Override
    public List<Weighing> getWeighings() {
        return emptyList();
    }
}
