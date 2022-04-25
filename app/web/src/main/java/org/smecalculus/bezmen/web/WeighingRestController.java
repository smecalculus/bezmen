package org.smecalculus.bezmen.web;

import lombok.RequiredArgsConstructor;
import org.smecalculus.bezmen.api.WeighingRm;
import org.smecalculus.bezmen.api.WeighingSpecRm;
import org.smecalculus.bezmen.core.weighing.WeighingApi;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequiredArgsConstructor
public class WeighingRestController {
    private final WeighingApi weighingApi;

    @PostMapping("/weighings")
    ResponseEntity<Object> add(@Valid @RequestBody WeighingSpecRm weighingSpecRm) {
        try {
            weighingApi.register(weighingSpecRm);
            return ResponseEntity.status(CREATED).build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("error");
        }
    }

    @GetMapping("/weighings")
    List<WeighingRm> getWeighings() {
        return weighingApi.getWeighings();
    }
}
