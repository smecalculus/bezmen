package org.smecalculus.bezmen.fixture;

import org.smecalculus.bezmen.configuration.OrmPropsCfg;
import org.smecalculus.bezmen.modeling.OrmProps;

import static org.smecalculus.bezmen.modeling.OrmMode.SPRING_DATA;

public class OrmPropsFixture {

    public static OrmProps.Builder ormProps() {
        return OrmProps.builder()
                .mode(SPRING_DATA);
    }

    public static OrmPropsCfg ormPropsCfg() {
        OrmPropsCfg ormPropsCfg = new OrmPropsCfg();
        ormPropsCfg.setMode(SPRING_DATA.name());
        return ormPropsCfg;
    }
}
