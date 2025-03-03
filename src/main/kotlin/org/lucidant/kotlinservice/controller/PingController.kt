package org.lucidant.kotlinservice.controller

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.lucidant.kotlinservice.configuration.SampleProperties
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@Tag(name = "Ping")
@RestController
class PingController(val sampleProperties: SampleProperties) {

  @Operation(summary = "Endpoint to test status of server")
  @CrossOrigin
  @RequestMapping(value = ["/ping"], method = [RequestMethod.GET], produces = ["text/plain"])
  fun ping(): String {
    val sam = sampleProperties.title
    return "pong $sam"
  }
}
