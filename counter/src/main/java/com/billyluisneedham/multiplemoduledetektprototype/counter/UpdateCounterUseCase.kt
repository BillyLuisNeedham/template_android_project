package com.billyluisneedham.multiplemoduledetektprototype.counter

internal class UpdateCounterUseCase(
    private val isWithinLimits: CountIsWithinLimitsUseCase
) {

    fun execute(request: Int): Result<Int> {
        return Result.success(request)
    }
}

internal interface CountIsWithinLimitsUseCase {
    fun execute(request: Int): Result<Boolean>
}