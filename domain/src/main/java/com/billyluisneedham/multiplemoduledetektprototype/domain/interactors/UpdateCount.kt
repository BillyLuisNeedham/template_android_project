package com.billyluisneedham.multiplemoduledetektprototype.domain.interactors

import com.billyluisneedham.multiplemoduledetektprototype.data.repository.count.CountRepository
import javax.inject.Inject

class UpdateCount @Inject constructor(
    private val countRepository: CountRepository
) {
    suspend fun execute(request: Int): Result<Unit> {
        return countRepository.updateCount(request)
    }

}

