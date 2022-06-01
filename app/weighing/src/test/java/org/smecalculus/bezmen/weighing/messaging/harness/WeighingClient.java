package org.smecalculus.bezmen.weighing.messaging.harness;

public interface WeighingClient {
    <P, Q> WeighingResponse<Q> send(WeighingRequest<P, Q> request);
}
