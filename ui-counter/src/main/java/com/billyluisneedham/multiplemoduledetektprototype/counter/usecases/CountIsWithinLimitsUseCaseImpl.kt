package com.billyluisneedham.multiplemoduledetektprototype.counter.usecases

internal object CountIsWithinLimitsUseCaseImpl : CountIsWithinLimitsUseCase {
    private const val MIN_VALUE = 0
    private const val MAX_VALUE = 10

    override fun execute(request: Int): Boolean =
        request in MIN_VALUE..MAX_VALUE

}