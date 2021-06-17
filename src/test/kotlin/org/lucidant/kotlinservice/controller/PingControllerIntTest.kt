package org.lucidant.kotlinservice.controller

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.lucidant.kotlinservice.integration.IntegrationTestBase

class PingControllerIntTest : IntegrationTestBase() {

  @Test
  fun whenPing_thenPong() {
    // The BodyContentSpec has built-in functions for looking at JSON and XML but not sure for strings
    val str = webTestClient.get().uri("/ping")
        .exchange()
        .expectStatus().isOk
        .expectBody()
        .returnResult()
        .responseBodyContent?.let {
        String(
          bytes = it
        )
      }
    assertThat(str).isEqualTo("pong")
  }
}
