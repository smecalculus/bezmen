package smecalculus.bezmen.fixture;

import static smecalculus.bezmen.fixture.OrmPropsFixture.ormProps;
import static smecalculus.bezmen.fixture.OrmPropsFixture.ormPropsCfg;
import static smecalculus.bezmen.fixture.VendorPropsFixture.vendorProps;
import static smecalculus.bezmen.fixture.VendorPropsFixture.vendorPropsCfg;

import smecalculus.bezmen.configuration.StorageProps;
import smecalculus.bezmen.configuration.StoragePropsCfg;

public class DataPropsFixture {

    public static StorageProps.Builder dataProps() {
        return StorageProps.builder()
                .vendorProps(vendorProps().build())
                .ormProps(ormProps().build());
    }

    public static StoragePropsCfg storagePropsCfg() {
        StoragePropsCfg storagePropsCfg = new StoragePropsCfg();
        storagePropsCfg.setVendor(vendorPropsCfg());
        storagePropsCfg.setOrm(ormPropsCfg());
        return storagePropsCfg;
    }
}
