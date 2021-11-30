package com.billyluisneedham.multiplemoduledetektprototype.data.repository.count

import kotlinx.coroutines.flow.Flow

interface CountLocalDataSource {
    suspend fun updateCount(newCount: Int)
    fun getCount(): Flow<Int>
}
