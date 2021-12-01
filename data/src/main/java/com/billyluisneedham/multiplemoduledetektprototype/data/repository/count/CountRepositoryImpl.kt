package com.billyluisneedham.multiplemoduledetektprototype.data.repository.count

import com.billyluisneedham.multiplemoduledetektprototype.domain.repositories.CountRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CountRepositoryImpl @Inject constructor(
    private val countLocalDataSource: CountLocalDataSource
): CountRepository {
    override suspend fun updateCount(newCount: Int) =
        runCatching {
            countLocalDataSource.updateCount(newCount = newCount)
        }.onSuccess {
            Result.success(Unit)
        }

    override fun getCount() = countLocalDataSource.getCount()
}