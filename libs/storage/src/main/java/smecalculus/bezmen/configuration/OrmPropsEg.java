package smecalculus.bezmen.configuration;

import static smecalculus.bezmen.configuration.OrmMode.SPRING_DATA;

public class OrmPropsEg {
    public static class Pojos {
        public static OrmPropsCfg ormPropsCfg() {
            OrmPropsCfg ormPropsCfg = new OrmPropsCfg();
            ormPropsCfg.setMode(SPRING_DATA.name());
            return ormPropsCfg;
        }
    }
    public static class Builders {
        public static OrmProps.Builder ormProps() {
            return OrmProps.builder().mode(SPRING_DATA);
        }
    }
}
