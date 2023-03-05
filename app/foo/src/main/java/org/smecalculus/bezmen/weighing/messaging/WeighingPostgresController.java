package org.smecalculus.bezmen.weighing.messaging;

import org.smecalculus.bezmen.api.WeighingSpecRm;

import java.util.List;

public record WeighingPostgresController(
        WeighingApi weighingApi
) {

    void handle(List<WeighingSpecRm> weighingSpecRms) {
        try {
            weighingApi.register(weighingSpecRms);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
