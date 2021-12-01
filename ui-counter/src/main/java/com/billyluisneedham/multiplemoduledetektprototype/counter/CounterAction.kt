package com.billyluisneedham.multiplemoduledetektprototype.counter

internal sealed class CounterAction {
    data class UpdateCount(val newCount: Int): CounterAction()
}