package com.billyluisneedham.multiplemoduledetektprototype.counter.usecases

internal interface CountIsWithinLimitsUseCase {
    fun execute(request: Int): Boolean
}