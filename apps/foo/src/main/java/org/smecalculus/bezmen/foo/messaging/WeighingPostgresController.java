package org.smecalculus.bezmen.foo.messaging;

import org.smecalculus.bezmen.client.WeighingSpecRm;

import java.util.List;

public record WeighingPostgresController(
        SepulkaClient sepulkaClient
) {

    void handle(List<WeighingSpecRm> weighingSpecRms) {
        try {
            sepulkaClient.register(weighingSpecRms);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
