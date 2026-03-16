/*
 * Copyright 2024 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.ai.client.generativeai.type

import io.kotest.matchers.shouldBe
import org.junit.Test

class ExceptionTests {

  @Test
  fun `UnsupportedUserLocationException secondary constructor with cause`() {
    val cause = RuntimeException("original cause")
    val exception = UnsupportedUserLocationException(cause)

    exception.message shouldBe "User location is not supported for the API use."
    exception.cause shouldBe cause
  }

  @Test
  fun `UnsupportedUserLocationException primary constructor with message and cause`() {
    val cause = RuntimeException("original cause")
    val message = "custom message"
    val exception = UnsupportedUserLocationException(message, cause)

    exception.message shouldBe message
    exception.cause shouldBe cause
  }

  @Test
  fun `PromptBlockedException secondary constructor with cause`() {
    val response = GenerateContentResponse(listOf(), PromptFeedback(null, listOf()), UsageMetadata(0, 0, 0))
    val cause = RuntimeException("original cause")
    val exception = PromptBlockedException(response, cause)

    exception.message shouldBe "Prompt was blocked: null"
    exception.cause shouldBe cause
    exception.response shouldBe response
  }

  @Test
  fun `PromptBlockedException primary constructor with message and cause`() {
    val response = GenerateContentResponse(listOf(), PromptFeedback(null, listOf()), UsageMetadata(0, 0, 0))
    val cause = RuntimeException("original cause")
    val message = "custom message"
    val exception = PromptBlockedException(response, message, cause)

    exception.message shouldBe message
    exception.cause shouldBe cause
    exception.response shouldBe response
  }
}
