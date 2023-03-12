package org.smecalculus.bezmen.foo.fixtures;

import org.smecalculus.bezmen.api.WeighingErrorRm;
import org.smecalculus.bezmen.api.WeighingRm;
import org.smecalculus.bezmen.api.WeighingSpecRm;
import org.smecalculus.bezmen.foo.messaging.harness.WeighingRequest;
import org.smecalculus.bezmen.foo.messaging.harness.WeighingResponse;
import org.smecalculus.bezmen.foo.service.Weighing;

import java.util.UUID;

import static java.util.Collections.emptyMap;

public class WeighingFixtures {

    public static Weighing.Builder newWeighing() {
        return Weighing.builder()
                .id(UUID.randomUUID());
    }

    public static WeighingRm newWeighingRm() {
        WeighingRm weighingRm = new WeighingRm();
        return weighingRm;
    }

    public static WeighingSpecRm newWeighingSpecRm() {
        WeighingSpecRm weighingSpecRm = new WeighingSpecRm();
        weighingSpecRm.setFoo("foo");
        return weighingSpecRm;
    }

    public static <P, Q> WeighingRequest.Builder<P, Q> newWeighingRequest(Class<Q> expectedType) {
        return WeighingRequest.<P, Q>builder()
                .metadata(emptyMap())
                .responseType(expectedType);
    }

    public static <Q> WeighingResponse.Builder<Q> newWeighingResponse() {
        return WeighingResponse.<Q>builder();
    }

    public static WeighingErrorRm newWeighingErrorRm() {
        WeighingErrorRm errorRm = new WeighingErrorRm();
        return errorRm;
    }

    public static WeighingErrorRm newWeighingErrorRm(String message) {
        WeighingErrorRm errorRm = newWeighingErrorRm();
        errorRm.setMessage(message);
        return errorRm;
    }
}