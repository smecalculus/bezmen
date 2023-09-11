package org.smecalculus.bezmen.fixture;

import org.smecalculus.bezmen.configuration.spec.H2Props;
import org.smecalculus.bezmen.configuration.spec.VendorMode;
import org.smecalculus.bezmen.configuration.spec.VendorProps;
import org.smecalculus.bezmen.configuration.spec.VendorPropsCfg;

public class VendorPropsFixture {
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

    public static VendorPropsCfg vendorPropsCfg() {
        VendorPropsCfg vendorPropsCfg = new VendorPropsCfg();
        vendorPropsCfg.setMode(VendorMode.H2.name());
        return vendorPropsCfg;
    }
}
