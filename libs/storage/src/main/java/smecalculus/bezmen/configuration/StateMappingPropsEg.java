package smecalculus.bezmen.configuration;

import static smecalculus.bezmen.configuration.StateMappingMode.SPRING_DATA;

public class StateMappingPropsEg {
    public static class Pojos {
        public static StateMappingPropsCfg stateMappingPropsCfg() {
            return new StateMappingPropsCfg().setMode(SPRING_DATA.name());
        }
    }

    public static class Builders {
        public static StateMappingProps.Builder stateMappingProps() {
            return StateMappingProps.builder().mappingMode(SPRING_DATA);
        }
    }
}
