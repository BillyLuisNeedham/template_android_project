package com.billyluisneedham.multiplemoduledetektprototype.counter

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test
import java.lang.IllegalStateException


class UpdateCounterUseCaseTest {

    @Test
    fun `if CountIsWithinLimitsUseCase is true, returns the request int wrapped in a Result success`() {
        val testInt = 5
        val isWithinLimits = object : CountIsWithinLimitsUseCase {
            override fun execute(request: Int): Result<Boolean> = Result.success(true)
        }

        val updateCounterUseCase = UpdateCounterUseCase(isWithinLimits = isWithinLimits)

        val result = updateCounterUseCase.execute(testInt)
        assertThat(result, `is`(Result.success(testInt)))
    }

    @Test
    fun `if CountIsWithinLimitsUseCase returns false, returns an IllegalStateException wrapped in a Result error`() {
        val testInt = 100
        val isWithinLimits = object : CountIsWithinLimitsUseCase {
            override fun execute(request: Int): Result<Boolean> = Result.success(false)
        }

        val updateCounterUseCase = UpdateCounterUseCase(isWithinLimits = isWithinLimits)

        val result = updateCounterUseCase.execute(testInt)
        assertThat(result, `is`(Result.failure(IllegalStateException())))


    }
}