package com.billyluisneedham.multiplemoduledetektprototype.domain.observers

import com.billyluisneedham.multiplemoduledetektprototype.domain.repositories.CountRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ObserveCount @Inject constructor(
    private val countRepository: CountRepository
) {

    fun createObservable(): Flow<Int> {
        return countRepository.getCount()
    }
}