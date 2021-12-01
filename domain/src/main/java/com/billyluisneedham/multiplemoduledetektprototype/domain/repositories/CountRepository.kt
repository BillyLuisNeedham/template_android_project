package com.billyluisneedham.multiplemoduledetektprototype.domain.repositories

import kotlinx.coroutines.flow.Flow

interface CountRepository {
    suspend fun updateCount(newCount: Int): Result<Unit>
    fun getCount(): Flow<Int>
}