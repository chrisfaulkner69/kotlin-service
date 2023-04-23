package org.lucidant.kotlinservice

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class NullSafety {

    private val nullableString: String? = null
    private var nonNullableString: String = "A"
    // Would give compile error
    // val stringLength = nullableString.length // This will cause a compile-time error

    @ParameterizedTest
    @MethodSource("addNumbers")
    fun `show some parameters`(a: Int, b: Int, expected: Int) {
        assertThat(expected).isEqualTo(a + b)
    }

    @Test
    fun showNullableChain() {
        val stringLength = nullableString?.length ?: 0
        assertThat(stringLength).isEqualTo(0)
        nonNullableString = "@"
        // would be a compile error
        // nonNullableString = null
        assertThat(nonNullableString.length).isEqualTo(1)
    }

    companion object {
        @JvmStatic
        fun addNumbers() = listOf(
            Arguments.of(1, 2, 3),
            Arguments.of(4, 5, 9),
            Arguments.of(6, 7, 13)
        )
    }


}

