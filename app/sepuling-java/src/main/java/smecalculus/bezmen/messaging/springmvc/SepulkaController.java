package smecalculus.bezmen.messaging.springmvc;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import smecalculus.bezmen.messaging.SepulkaClient;
import smecalculus.bezmen.messaging.SepulkaMessageEm;
import smecalculus.bezmen.messaging.SepulkaMessageEm.RegistrationRequest;
import smecalculus.bezmen.messaging.SepulkaMessageEm.RegistrationResponse;
import smecalculus.bezmen.messaging.SepulkaMessageEm.ViewResponse;

@RestController
@RequestMapping("sepulkas")
@RequiredArgsConstructor
public class SepulkaController {

    @NonNull
    private SepulkaClient client;

    @PostMapping
    ResponseEntity<RegistrationResponse> register(@RequestBody RegistrationRequest request) {
        var response = client.register(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{externalId}")
    ResponseEntity<ViewResponse> view(@PathVariable("externalId") String externalId) {
        var request = new SepulkaMessageEm.ViewRequest();
        request.setExternalId(externalId);
        var response = client.view(request);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
