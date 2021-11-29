package com.billyluisneedham.multiplemoduledetektprototype.domain.interactors

internal interface CountIsWithinLimitsUseCase {
    fun execute(request: Int): Boolean
}