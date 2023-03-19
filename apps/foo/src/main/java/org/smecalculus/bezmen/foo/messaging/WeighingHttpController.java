package org.smecalculus.bezmen.foo.messaging;

import org.smecalculus.bezmen.client.WeighingErrorRm;
import org.smecalculus.bezmen.client.WeighingRm;
import org.smecalculus.bezmen.client.WeighingSpecRm;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/weighings")
record WeighingHttpController(
        WeighingApi weighingApi
) {

    @PostMapping
    ResponseEntity<Object> add(@RequestBody WeighingSpecRm weighingSpecRm) {
        try {
            weighingApi.register(weighingSpecRm);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (Exception e) {
            WeighingErrorRm weighingErrorRm = new WeighingErrorRm();
            weighingErrorRm.setMessage(e.getMessage());
            return ResponseEntity.internalServerError()
                    .body(weighingErrorRm);
        }
    }

    @GetMapping
    List<WeighingRm> getWeighings() {
        return weighingApi.getWeighings();
    }
}
