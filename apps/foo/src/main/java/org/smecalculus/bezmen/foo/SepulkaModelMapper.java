package org.smecalculus.bezmen.foo;

import org.mapstruct.Mapper;
import org.smecalculus.bezmen.client.WeighingRm;
import org.smecalculus.bezmen.client.WeighingSpecRm;
import org.smecalculus.bezmen.foo.data.SepulkaRec;
import org.smecalculus.bezmen.foo.service.Sepulka;
import org.smecalculus.bezmen.foo.service.WeighingSpec;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SepulkaModelMapper {

    WeighingSpec from(WeighingSpecRm weighingSpecRm);

    WeighingRm toRm(Sepulka sepulka);

    List<WeighingRm> toRm(List<Sepulka> sepulkas);

    SepulkaRec toDm(Sepulka sepulka);

    Sepulka from(SepulkaRec sepulkaRec);

    List<Sepulka> from(Iterable<SepulkaRec> weighingDms);
}
