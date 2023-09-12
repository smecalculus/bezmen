package smecalculus.bezmen.fixture;

import static smecalculus.bezmen.fixture.OrmPropsFixture.ormProps;
import static smecalculus.bezmen.fixture.OrmPropsFixture.ormPropsCfg;
import static smecalculus.bezmen.fixture.VendorPropsFixture.vendorProps;
import static smecalculus.bezmen.fixture.VendorPropsFixture.vendorPropsCfg;

import smecalculus.bezmen.configuration.spec.DataProps;
import smecalculus.bezmen.configuration.spec.DataPropsCfg;

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
