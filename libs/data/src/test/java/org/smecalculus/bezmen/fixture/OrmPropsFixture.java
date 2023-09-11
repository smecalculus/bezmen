package org.smecalculus.bezmen.fixture;

import static org.smecalculus.bezmen.configuration.spec.OrmMode.SPRING_DATA;

import org.smecalculus.bezmen.configuration.spec.OrmProps;
import org.smecalculus.bezmen.configuration.spec.OrmPropsCfg;

public class OrmPropsFixture {

    public static OrmProps.Builder ormProps() {
        return OrmProps.builder().mode(SPRING_DATA);
    }

    public static OrmPropsCfg ormPropsCfg() {
        OrmPropsCfg ormPropsCfg = new OrmPropsCfg();
        ormPropsCfg.setMode(SPRING_DATA.name());
        return ormPropsCfg;
    }
}
