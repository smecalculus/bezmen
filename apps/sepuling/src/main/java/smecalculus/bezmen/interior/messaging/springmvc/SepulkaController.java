package smecalculus.bezmen.interior.messaging.springmvc;

import lombok.NonNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import smecalculus.bezmen.exterior.messaging.SepulkaClient;
import smecalculus.bezmen.exterior.messaging.SepulkaRegisterSliceMsg;
import smecalculus.bezmen.exterior.messaging.SepulkaRegisteredSliceMsg;

@RestController
@RequestMapping("sepulkas")
public record SepulkaController(@NonNull SepulkaClient client) {

    @PostMapping
    ResponseEntity<SepulkaRegisteredSliceMsg> register(@RequestBody SepulkaRegisterSliceMsg registerSliceMsg) {
        var registeredSliceMsg = client.register(registerSliceMsg);
        return ResponseEntity.status(HttpStatus.CREATED).body(registeredSliceMsg);
    }
}
