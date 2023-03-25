package org.smecalculus.bezmen.client;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public record BezmenClientJavaHttp(
        ObjectMapper mapper,
        HttpClient client
) implements BezmenClient {

    @Override
    public SepulkaRegRes register(SepulkaRegReq request) {
        try {
            String jsonRequest = mapper.writeValueAsString(request);
            HttpRequest httpRequest = HttpRequest.newBuilder()
                    .uri(URI.create("http://localhost:8080/sepulkas"))
                    .POST(BodyPublishers.ofString(jsonRequest))
                    .header("Content-Type", "application/json")
                    .header("Accept", "application/json")
                    .build();
            HttpResponse<String> httpResponse = client.send(httpRequest, BodyHandlers.ofString());
            return mapper.readValue(httpResponse.body(), SepulkaRegRes.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
