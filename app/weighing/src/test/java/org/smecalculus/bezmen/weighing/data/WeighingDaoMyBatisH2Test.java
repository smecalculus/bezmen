package org.smecalculus.bezmen.weighing.data;

import org.smecalculus.bezmen.weighing.WeighingMapper;
import org.smecalculus.bezmen.weighing.data.mybatis.WeighingSqlMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = WeighingDaoMyBatisH2Beans.class)
public class WeighingDaoMyBatisH2Test extends WeighingDaoBaseTest {

    @Autowired
    private WeighingMapper mapper;
    @Autowired
    private WeighingSqlMapper sqlMapper;

    @Override
    WeighingDao underTest() {
        return new WeighingDaoMyBatisImpl(mapper, sqlMapper);
    }
}
