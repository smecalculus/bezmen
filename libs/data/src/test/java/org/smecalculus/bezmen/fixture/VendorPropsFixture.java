package org.smecalculus.bezmen.fixture;

import org.smecalculus.bezmen.configuration.VendorPropsCfg;
import org.smecalculus.bezmen.modeling.H2Props;
import org.smecalculus.bezmen.modeling.VendorMode;
import org.smecalculus.bezmen.modeling.VendorProps;

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
