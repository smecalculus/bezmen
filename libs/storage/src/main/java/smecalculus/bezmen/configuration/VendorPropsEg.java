package smecalculus.bezmen.configuration;

public class VendorPropsEg {
    public static class Pojos {
        public static VendorPropsCfg vendorPropsCfg() {
            VendorPropsCfg vendorPropsCfg = new VendorPropsCfg();
            vendorPropsCfg.setMode(VendorMode.H2.name());
            return vendorPropsCfg;
        }
    }

    public static class Builders {
        public static VendorProps.Builder vendorProps() {
            return VendorProps.builder()
                    .mode(VendorMode.H2)
                    .h2Props(H2Props.builder()
                            .url("jdbc:h2:mem:db;DB_CLOSE_DELAY=-1")
                            .username("sa")
                            .password("sa")
                            .build())
                    .postgresProps(null);
        }
    }
}
