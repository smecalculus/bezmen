package smecalculus.bezmen.interior.messaging.springmvc;

import lombok.NonNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import smecalculus.bezmen.exterior.messaging.SepulkaClient;
import smecalculus.bezmen.exterior.messaging.SepulkaMsgMapper;
import smecalculus.bezmen.exterior.messaging.SepulkaRegisterSlice;
import smecalculus.bezmen.exterior.messaging.SepulkaRegisterSliceMsg;
import smecalculus.bezmen.exterior.messaging.SepulkaRegisteredSlice;
import smecalculus.bezmen.exterior.messaging.SepulkaRegisteredSliceMsg;
import smecalculus.bezmen.interior.validation.EdgeValidator;

@RestController
@RequestMapping("sepulkas")
public record SepulkaController(
        @NonNull EdgeValidator validator, @NonNull SepulkaClient client, @NonNull SepulkaMsgMapper mapper) {

    @PostMapping
    ResponseEntity<SepulkaRegisteredSliceMsg> register(@RequestBody SepulkaRegisterSliceMsg sliceMsg) {
        validator.validate(sliceMsg);
        SepulkaRegisterSlice requestSlice = mapper.toDomain(sliceMsg);
        SepulkaRegisteredSlice responseSlice = client.register(requestSlice);
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.toMsg(responseSlice));
    }
}
