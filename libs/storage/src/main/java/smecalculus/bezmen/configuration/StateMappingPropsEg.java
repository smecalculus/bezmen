package smecalculus.bezmen.configuration;

import static smecalculus.bezmen.configuration.StateMappingMode.SPRING_DATA;

public class StateMappingPropsEg {
    public static class Pojos {
        public static StateMappingPropsEdge stateMappingPropsEdge() {
            var propsEdge = new StateMappingPropsEdge();
            propsEdge.setMode(SPRING_DATA.name());
            return propsEdge;
        }
    }

    public static class Builders {
        public static StateMappingProps.Builder stateMappingProps() {
            return StateMappingProps.builder().mappingMode(SPRING_DATA);
        }

        public static StateMappingProps.Builder stateMappingProps(StateMappingMode mode) {
            return stateMappingProps().mappingMode(mode);
        }
    }
}
