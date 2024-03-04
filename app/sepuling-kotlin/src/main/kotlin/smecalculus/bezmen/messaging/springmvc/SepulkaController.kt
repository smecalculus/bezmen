package smecalculus.bezmen.messaging.springmvc

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import smecalculus.bezmen.messaging.SepulkaClient
import smecalculus.bezmen.messaging.SepulkaMessageEm.RegistrationRequest
import smecalculus.bezmen.messaging.SepulkaMessageEm.RegistrationResponse
import smecalculus.bezmen.messaging.SepulkaMessageEm.ViewRequest
import smecalculus.bezmen.messaging.SepulkaMessageEm.ViewResponse

@RestController
@RequestMapping("sepulkas")
class SepulkaController(
    private val client: SepulkaClient,
) {
    @PostMapping
    fun register(
        @RequestBody request: RegistrationRequest,
    ): ResponseEntity<RegistrationResponse> {
        val response = client.register(request)
        return ResponseEntity.status(HttpStatus.CREATED).body(response)
    }

    @GetMapping("/{externalId}")
    fun register(
        @PathVariable("externalId") externalId: String,
    ): ResponseEntity<ViewResponse> {
        val request = ViewRequest()
        request.externalId = externalId
        val response = client.view(request)
        return ResponseEntity.status(HttpStatus.OK).body(response)
    }
}
