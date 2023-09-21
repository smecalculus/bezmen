package smecalculus.bezmen.messaging.springmvc;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import smecalculus.bezmen.messaging.SepulkaClient;
import smecalculus.bezmen.messaging.SepulkaMsgMapper;
import smecalculus.bezmen.messaging.SepulkaRegReq;
import smecalculus.bezmen.messaging.SepulkaRegReqMsg;
import smecalculus.bezmen.messaging.SepulkaRegRes;
import smecalculus.bezmen.messaging.SepulkaRegResMsg;

@RestController
@RequestMapping("sepulkas")
public record SepulkaController(SepulkaClient client, SepulkaMsgMapper mapper) {
    @PostMapping
    ResponseEntity<SepulkaRegResMsg> register(@RequestBody SepulkaRegReqMsg sepulkaRegReqMsg) {
        SepulkaRegReq sepulkaRegReq = mapper.toDomain(sepulkaRegReqMsg);
        SepulkaRegRes sepulkaRegRes = client.register(sepulkaRegReq);
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.toMsg(sepulkaRegRes));
    }
}
