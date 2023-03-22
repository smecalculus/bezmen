package org.smecalculus.bezmen.foo.messaging.springweb;

import org.smecalculus.bezmen.client.SepulkaClient;
import org.smecalculus.bezmen.client.SepulkaRegReq;
import org.smecalculus.bezmen.client.SepulkaRegRes;
import org.smecalculus.bezmen.foo.messaging.SepulkaMsgMapper;
import org.smecalculus.bezmen.foo.messaging.SepulkaRegReqMsg;
import org.smecalculus.bezmen.foo.messaging.SepulkaRegResMsg;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sepulkas")
public record SepulkaController(
        SepulkaClient client,
        SepulkaMsgMapper mapper
) {
    @PostMapping
    ResponseEntity<SepulkaRegResMsg> register(@RequestBody SepulkaRegReqMsg sepulkaRegReqMsg) {
        SepulkaRegReq sepulkaRegReq = mapper.toDomain(sepulkaRegReqMsg);
        SepulkaRegRes sepulkaRegRes = client.register(sepulkaRegReq);
        return ResponseEntity.status(HttpStatus.CREATED)
                .contentType(MediaType.APPLICATION_JSON)
                .body(mapper.toMsg(sepulkaRegRes));
    }
}
