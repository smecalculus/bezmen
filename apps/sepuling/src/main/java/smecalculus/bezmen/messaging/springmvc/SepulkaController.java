package smecalculus.bezmen.messaging.springmvc;

import lombok.NonNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import smecalculus.bezmen.messaging.SepulkaMsgMapper;
import smecalculus.bezmen.messaging.SepulkaRegReqMsg;
import smecalculus.bezmen.messaging.SepulkaRegResMsg;
import smecalculus.bezmen.messaging.client.SepulkaClient;
import smecalculus.bezmen.messaging.client.SepulkaRegReq;
import smecalculus.bezmen.messaging.client.SepulkaRegRes;
import smecalculus.bezmen.validation.EdgeValidator;

@RestController
@RequestMapping("sepulkas")
public record SepulkaController(
        @NonNull EdgeValidator validator, @NonNull SepulkaClient client, @NonNull SepulkaMsgMapper mapper) {

    @PostMapping
    ResponseEntity<SepulkaRegResMsg> register(@RequestBody SepulkaRegReqMsg sepulkaRegReqMsg) {
        // TODO: контроллер отвечает только за сборку msg-модели и валидацию
        validator.validate(sepulkaRegReqMsg);
        SepulkaRegReq sepulkaRegReq = mapper.toDomain(sepulkaRegReqMsg);
        SepulkaRegRes sepulkaRegRes = client.register(sepulkaRegReq);
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.toMsg(sepulkaRegRes));
    }
}
