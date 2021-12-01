package com.billyluisneedham.multiplemoduledetektprototype.data.repository.count

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.Is.`is`
import org.junit.Test
import java.lang.Exception


class CountRepositoryImplTest {

    class TestException : Exception()

    @Test
    fun `updateCount calls CountLocalDataSource updateCount`() {
        runBlocking {
            var count = 0
            val expectedCount = 1
            val countLocalDataSource = object : CountLocalDataSource {
                override suspend fun updateCount(newCount: Int) {
                    count = newCount
                }
                override fun getCount(): Flow<Int> = flow {}
            }
            val countRepository = CountRepositoryImpl(countLocalDataSource)

            countRepository.updateCount(expectedCount)

            assertThat(count, `is`(expectedCount))
        }
    }

    @Test
    fun `updateCount updates count via CountLocalDataSource on success returns result successes unit`() {
        runBlocking {
            val countLocalDataSource = object : CountLocalDataSource {
                override suspend fun updateCount(newCount: Int) {}
                override fun getCount(): Flow<Int> = flow {}
            }
            val countRepository = CountRepositoryImpl(countLocalDataSource = countLocalDataSource)

            val result = countRepository.updateCount(2)

            assertThat(result, `is`(Result.success(Unit)))
        }
    }

    @Test
    fun `exceptions thrown in CountLocalDataSource are caught and passed in a result failure`() {
        runBlocking {
            var isTextException = false
            val countLocalDataSource = object : CountLocalDataSource {
                override suspend fun updateCount(newCount: Int) {
                    throw TestException()
                }
                override fun getCount(): Flow<Int> = flow {}
            }
            val countRepository = CountRepositoryImpl(countLocalDataSource = countLocalDataSource)

            val result = countRepository.updateCount(2)

            if (result.isFailure) {
                if (result.exceptionOrNull() is TestException) {
                    isTextException = true
                }
            }
            assertThat(isTextException, `is`(true))
        }
    }

    @Test
    fun `getCount returns a flow of the count from CountLocalDataSource`() {
        runBlocking {
            val expectedNumber = 55
            val expectedFlow = flow {
                emit(expectedNumber)
            }
            val countLocalDataSource = object : CountLocalDataSource {
                override suspend fun updateCount(newCount: Int) {}
                override fun getCount(): Flow<Int> = expectedFlow
            }
            val countRepository = CountRepositoryImpl(countLocalDataSource = countLocalDataSource)

            val result = countRepository.getCount().firstOrNull()

            assertThat(result, `is`(expectedNumber))
        }
    }
}