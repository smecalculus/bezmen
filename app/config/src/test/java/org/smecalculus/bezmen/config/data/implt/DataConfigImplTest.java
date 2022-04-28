package org.smecalculus.bezmen.config.data.implt;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.smecalculus.bezmen.config.data.contract.ConfigBeans;
import org.smecalculus.bezmen.config.data.impl.DataConfigImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = ConfigBeans.class)
class DataConfigImplTest {

    @Autowired
    private DataConfigImpl dataConfig;

    @Test
    void getDataProps() {
        dataConfig.getDataProps();
    }
}