package com.billyluisneedham.multiplemoduledetektprototype.domain.interactors

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test


class UpdateCounterUseCaseTest {

    @Test
    fun `if CountIsWithinLimitsUseCase is true, returns the request int wrapped in a Result success`() {
        val testInt = 5
        val isWithinLimits = object :
            CountIsWithinLimitsUseCase {
            override fun execute(request: Int): Boolean = true
        }

        val updateCounterUseCase =
            UpdateCounterUseCase(
                isWithinLimits = isWithinLimits
            )

        val result = updateCounterUseCase.execute(testInt)
        assertThat(result, `is`(Result.success(testInt)))
    }

    @Test
    fun `if CountIsWithinLimitsUseCase returns false, returns an OutOfCounterLimits exception wrapped in a Result failure`() {
        val testInt = 100
        var isOutOfCounterLimitsException = false
        val isWithinLimits = object :
            CountIsWithinLimitsUseCase {
            override fun execute(request: Int): Boolean = false
        }

        val updateCounterUseCase =
            UpdateCounterUseCase(
                isWithinLimits = isWithinLimits
            )

        assertThat(isOutOfCounterLimitsException, `is`(false))
        val result = updateCounterUseCase.execute(testInt)
        result.onFailure {
            when (it) {
                is UpdateCounterUseCase.OutOfCounterLimits -> isOutOfCounterLimitsException = true
            }
        }
        assertThat(isOutOfCounterLimitsException, `is`(true))
    }

}