package com.billyluisneedham.multiplemoduledetektprototype.counter

internal class UpdateCounterUseCase(
    private val isWithinLimits: CountIsWithinLimitsUseCase
) {
    fun execute(request: Int): Result<Int> {
        return isWithinLimits.execute(request = request)
            .run {
                onCompletionWithinLimits(this, request = request)
            }

    }

    private fun onCompletionWithinLimits(withinLimits: Boolean, request: Int): Result<Int> =
        when (withinLimits) {
            true -> Result.success(request)
            false -> Result.failure(OutOfCounterLimits())
        }

}

internal class OutOfCounterLimits : Exception()

internal interface CountIsWithinLimitsUseCase {
    fun execute(request: Int): Boolean
}