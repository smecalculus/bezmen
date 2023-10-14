package smecalculus.bezmen.configuration;

import static smecalculus.bezmen.configuration.StateMappingMode.SPRING_DATA;

public class StateMappingPropsEg {
    public static class Pojos {
        public static StateMappingPropsCfg stateMappingPropsCfg() {
            StateMappingPropsCfg propsCfg = new StateMappingPropsCfg();
            propsCfg.setMode(SPRING_DATA.name());
            return propsCfg;
        }
    }

    public static class Builders {
        public static StateMappingProps.Builder stateMappingProps() {
            return StateMappingProps.builder().mappingMode(SPRING_DATA);
        }
    }
}
