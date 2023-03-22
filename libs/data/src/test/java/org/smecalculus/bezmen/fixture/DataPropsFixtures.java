package org.smecalculus.bezmen.fixture;

import org.smecalculus.bezmen.configuration.DataMode;
import org.smecalculus.bezmen.configuration.DataProps;
import org.smecalculus.bezmen.configuration.DataPropsCfg;
import org.smecalculus.bezmen.configuration.H2Props;

public class DataPropsFixtures {
    public static DataProps.Builder dataPropsPojo() {
        return DataProps.builder()
                .mode(DataMode.H2)
                .h2Props(H2Props.builder()
                        .url("jdbc:h2:mem:db;DB_CLOSE_DELAY=-1")
                        .username("sa")
                        .password("sa")
                        .build())
                .postgresProps(null);
    }

    public static DataPropsCfg dataPropsDTO() {
        DataPropsCfg dataPropsCfg = new DataPropsCfg();
        dataPropsCfg.setMode(DataMode.H2.name());
        return dataPropsCfg;
    }
}
