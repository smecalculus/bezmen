package org.smecalculus.bezmen.messaging.impl.springmvc;

import org.smecalculus.bezmen.messaging.spec.SepulkaClient;
import org.smecalculus.bezmen.messaging.spec.SepulkaMsgMapper;
import org.smecalculus.bezmen.messaging.spec.SepulkaRegReq;
import org.smecalculus.bezmen.messaging.spec.SepulkaRegReqMsg;
import org.smecalculus.bezmen.messaging.spec.SepulkaRegRes;
import org.smecalculus.bezmen.messaging.spec.SepulkaRegResMsg;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
