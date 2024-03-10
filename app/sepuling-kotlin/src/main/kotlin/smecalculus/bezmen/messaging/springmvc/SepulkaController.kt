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
import smecalculus.bezmen.messaging.SepulkaMessageEm.ViewingRequest
import smecalculus.bezmen.messaging.SepulkaMessageEm.ViewingResponse

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

    @GetMapping("/{internalId}")
    fun view(
        @PathVariable("internalId") id: String,
    ): ResponseEntity<ViewingResponse> {
        val request = ViewingRequest()
        request.internalId = id
        val response = client.view(request)
        return ResponseEntity.status(HttpStatus.OK).body(response)
    }
}
