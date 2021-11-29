package com.billyluisneedham.multiplemoduledetektprototype.counter

import com.billyluisneedham.multiplemoduledetektprototype.counter.usecases.CountIsWithinLimitsUseCaseImpl
import com.billyluisneedham.multiplemoduledetektprototype.counter.usecases.UpdateCounterUseCase

internal object DependencyInjector {
    fun provideUpdateCounterUseCase() =
        UpdateCounterUseCase(isWithinLimits = CountIsWithinLimitsUseCaseImpl)
}