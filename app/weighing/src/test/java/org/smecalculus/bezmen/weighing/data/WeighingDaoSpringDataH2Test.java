package org.smecalculus.bezmen.weighing.data;

import org.smecalculus.bezmen.weighing.WeighingMapper;
import org.smecalculus.bezmen.weighing.data.springdata.WeighingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = WeighingDaoSpringDataH2Beans.class)
public class WeighingDaoSpringDataH2Test extends WeighingDaoBaseTest {

    @Autowired
    private WeighingMapper mapper;
    @Autowired
    private WeighingRepository repository;

    @Override
    WeighingDao underTest() {
        return new WeighingDaoSpringDataImpl(mapper, repository);
    }
}
