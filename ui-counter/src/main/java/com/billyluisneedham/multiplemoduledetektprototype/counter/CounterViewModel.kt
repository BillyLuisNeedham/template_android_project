package com.billyluisneedham.multiplemoduledetektprototype.counter

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.billyluisneedham.multiplemoduledetektprototype.domain.interactors.UpdateCount
import com.billyluisneedham.multiplemoduledetektprototype.domain.observers.ObserveCount
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
internal class CounterViewModel @Inject constructor(
    private val updateCount: UpdateCount,
    observeCount: ObserveCount
) : ViewModel() {

    private val pendingActions = MutableSharedFlow<CounterAction>()

    val state: StateFlow<CounterViewState> = combine(
        observeCount.createObservable()
    ) {
        // TODO remove when done testing
        Log.d("billytest", "observeCount: $it")
        CounterViewState(
            count = it.first()
        )
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = CounterViewState()
    )

    init {
        viewModelScope.launch {
            pendingActions.collect { action ->
                when (action) {
                    is CounterAction.UpdateCount -> updateCountInState(newCount = action.newCount)
                }
            }
        }
    }

    internal fun submitAction(action: CounterAction) {
        viewModelScope.launch {
            pendingActions.emit(action)
        }
    }

    private fun updateCountInState(newCount: Int) {
        viewModelScope.launch {
            updateCount.execute(newCount)
        }
    }


}