package com.billyluisneedham.multiplemoduledetektprototype.counter

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun Counter() {
    Counter(
        viewModel = hiltViewModel()
    )
}

@Composable
internal fun Counter(
    viewModel: CounterViewModel
) {
    val viewState = viewModel.state.collectAsState()
    Counter(viewState = viewState.value) { action ->
        when (action) {
            is CounterAction.UpdateCount -> viewModel.submitAction(action)
        }
    }
}

@Composable
internal fun Counter(
    viewState: CounterViewState,
    actioner: (CounterAction) -> Unit
) {
    Scaffold {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = viewState.count.toString(),
                style = MaterialTheme.typography.h4
            )
        }
    }
}

@Preview
@Composable
fun PreviewCountDetails() {
    Counter(
        viewState = CounterViewState(),
        actioner = {}
    )
}