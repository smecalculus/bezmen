package smecalculus.bezmen.configuration;

import static smecalculus.bezmen.configuration.OrmPropsEg.Builders.ormProps;
import static smecalculus.bezmen.configuration.OrmPropsEg.Pojos.ormPropsCfg;
import static smecalculus.bezmen.configuration.VendorPropsEg.Builders.vendorProps;
import static smecalculus.bezmen.configuration.VendorPropsEg.Pojos.vendorPropsCfg;

public class StoragePropsEg {
    public static class Pojos {
        public static StoragePropsCfg storagePropsCfg() {
            StoragePropsCfg storagePropsCfg = new StoragePropsCfg();
            storagePropsCfg.setVendor(vendorPropsCfg());
            storagePropsCfg.setOrm(ormPropsCfg());
            return storagePropsCfg;
        }
    }

    public static class Builders {
        public static StorageProps.Builder storageProps() {
            return StorageProps.builder()
                    .vendorProps(vendorProps().build())
                    .ormProps(ormProps().build());
        }
    }
}
