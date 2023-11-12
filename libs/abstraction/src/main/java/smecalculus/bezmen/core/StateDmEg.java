package smecalculus.bezmen.core;

import static java.time.temporal.ChronoUnit.MICROS;

import java.time.LocalDateTime;
import java.util.UUID;
import smecalculus.bezmen.core.StateDm.AggregateRoot;
import smecalculus.bezmen.core.StateDm.Preview;
import smecalculus.bezmen.core.StateDm.Touch;

public class StateDmEg {
    public static StateDm.AggregateRoot.Builder aggregateRoot() {
        return AggregateRoot.builder()
                .internalId(UUID.randomUUID())
                .externalId(UUID.randomUUID().toString())
                .revision(0)
                .createdAt(LocalDateTime.now().truncatedTo(MICROS))
                .updatedAt(LocalDateTime.now().truncatedTo(MICROS));
    }

    public static StateDm.Existence.Builder existence() {
        return StateDm.Existence.builder().internalId(UUID.randomUUID());
    }

    public static StateDm.Preview.Builder preview(StateDm.AggregateRoot state) {
        return Preview.builder().externalId(state.externalId()).createdAt(state.createdAt());
    }

    public static StateDm.Touch.Builder touch(AggregateRoot state) {
        return Touch.builder().revision(state.revision()).updatedAt(state.updatedAt());
    }
}
