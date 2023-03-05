package org.smecalculus.bezmen.foo.messaging.harness;

public interface WeighingClient {
    <P, Q> WeighingResponse<Q> send(WeighingRequest<P, Q> request);
}
