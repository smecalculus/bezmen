package smecalculus.bezmen.messaging.springmvc;

import lombok.NonNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import smecalculus.bezmen.messaging.SepulkaMsgMapper;
import smecalculus.bezmen.messaging.SepulkaRegisterSliceMsg;
import smecalculus.bezmen.messaging.SepulkaRegisteredSliceMsg;
import smecalculus.bezmen.messaging.client.SepulkaClient;
import smecalculus.bezmen.messaging.client.SepulkaRegisterSlice;
import smecalculus.bezmen.messaging.client.SepulkaRegisteredSlice;
import smecalculus.bezmen.validation.EdgeValidator;

@RestController
@RequestMapping("sepulkas")
public record SepulkaController(
        @NonNull EdgeValidator validator, @NonNull SepulkaClient client, @NonNull SepulkaMsgMapper mapper) {

    @PostMapping
    ResponseEntity<SepulkaRegisteredSliceMsg> register(@RequestBody SepulkaRegisterSliceMsg sliceMsg) {
        validator.validate(sliceMsg);
        SepulkaRegisterSlice registerSlice = mapper.toDomain(sliceMsg);
        SepulkaRegisteredSlice registeredSlice = client.register(registerSlice);
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.toMsg(registeredSlice));
    }
}
