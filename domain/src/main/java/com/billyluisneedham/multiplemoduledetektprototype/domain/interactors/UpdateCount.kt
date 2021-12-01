package com.billyluisneedham.multiplemoduledetektprototype.domain.interactors

import com.billyluisneedham.multiplemoduledetektprototype.domain.repositories.CountRepository
import javax.inject.Inject

class UpdateCount @Inject constructor(
    private val countRepository: CountRepository
) {
    suspend fun execute(request: Int): Result<Unit> {
        return countRepository.updateCount(request)
    }

}

