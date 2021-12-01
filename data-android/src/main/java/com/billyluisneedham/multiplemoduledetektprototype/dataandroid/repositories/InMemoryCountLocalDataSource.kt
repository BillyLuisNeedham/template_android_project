package com.billyluisneedham.multiplemoduledetektprototype.dataandroid.repositories

import com.billyluisneedham.multiplemoduledetektprototype.data.repository.count.CountLocalDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class InMemoryCountLocalDataSource @Inject constructor() : CountLocalDataSource {
    private var count = MutableStateFlow(0)

    override suspend fun updateCount(newCount: Int) {
        count.value = newCount
    }

    override fun getCount(): Flow<Int> = count
}