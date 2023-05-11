package org.smecalculus.bezmen.fixture;

import static org.smecalculus.bezmen.fixture.OrmPropsFixture.ormProps;
import static org.smecalculus.bezmen.fixture.OrmPropsFixture.ormPropsCfg;
import static org.smecalculus.bezmen.fixture.VendorPropsFixture.vendorProps;
import static org.smecalculus.bezmen.fixture.VendorPropsFixture.vendorPropsCfg;

import org.smecalculus.bezmen.configuration.DataPropsCfg;
import org.smecalculus.bezmen.modeling.DataProps;

public class DataPropsFixture {

    public static DataProps.Builder dataProps() {
        return DataProps.builder()
                .vendorProps(vendorProps().build())
                .ormProps(ormProps().build());
    }

    public static DataPropsCfg dataPropsCfg() {
        DataPropsCfg dataPropsCfg = new DataPropsCfg();
        dataPropsCfg.setVendor(vendorPropsCfg());
        dataPropsCfg.setOrm(ormPropsCfg());
        return dataPropsCfg;
    }
}
