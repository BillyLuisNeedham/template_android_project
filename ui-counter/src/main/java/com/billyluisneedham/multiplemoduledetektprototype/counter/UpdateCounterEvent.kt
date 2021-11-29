package com.billyluisneedham.multiplemoduledetektprototype.counter

internal sealed interface UpdateCounterEvent {
    data class UpdateState(val newCount: Int): UpdateCounterEvent
}