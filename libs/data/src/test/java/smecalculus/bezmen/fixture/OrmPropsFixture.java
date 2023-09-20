package smecalculus.bezmen.fixture;

import static smecalculus.bezmen.configuration.spec.OrmMode.SPRING_DATA;

import smecalculus.bezmen.configuration.spec.OrmProps;
import smecalculus.bezmen.configuration.spec.OrmPropsCfg;

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
