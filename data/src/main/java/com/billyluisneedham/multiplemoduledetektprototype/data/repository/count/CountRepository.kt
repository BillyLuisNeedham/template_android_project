package com.billyluisneedham.multiplemoduledetektprototype.data.repository.count

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CountRepository @Inject constructor(
    private val countLocalDataSource: CountLocalDataSource
) {
    suspend fun updateCount(newCount: Int) =
        runCatching {
            countLocalDataSource.updateCount(newCount = newCount)
        }.onSuccess {
            Result.success(Unit)
        }

    fun getCount() = countLocalDataSource.getCount()
}