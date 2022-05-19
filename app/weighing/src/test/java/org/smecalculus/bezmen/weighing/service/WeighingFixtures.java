package org.smecalculus.bezmen.weighing.service;

import java.util.UUID;

public class WeighingFixtures {

    public static Weighing.Builder getWeighing() {
        return Weighing.builder()
                .id(UUID.randomUUID());
    }
}