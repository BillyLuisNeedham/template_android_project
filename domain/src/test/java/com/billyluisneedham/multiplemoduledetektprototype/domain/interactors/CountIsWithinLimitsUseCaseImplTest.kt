package com.billyluisneedham.multiplemoduledetektprototype.domain.interactors

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test


class CountIsWithinLimitsUseCaseImplTest {

    @Test
    fun `if count is less than 0 returns false`() {
        val result = CountIsWithinLimitsUseCaseImpl.execute(-1)

        assertThat(result, `is`(false))
    }

    @Test
    fun `if count is greater than 10 returns false`() {
        val result = CountIsWithinLimitsUseCaseImpl.execute(11)

        assertThat(result, `is`(false))
    }

    @Test
    fun `if count is between 0 and 10 returns true`() {
        val testRange = 0..10
        testRange.forEach {
            val result = CountIsWithinLimitsUseCaseImpl.execute(it)

            assertThat(result, `is`(true))
        }
    }
}