package com.billyluisneedham.multiplemoduledetektprototype.counter

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.billyluisneedham.mutliplemoduledetektprototype.commonui.ButtonBase

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
            modifier = Modifier
                .fillMaxSize()
                .padding(dimensionResource(id = R.dimen.default_padding)),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = viewState.count.toString(),
                style = MaterialTheme.typography.h4
            )
            ButtonRow(
                modifier = Modifier.fillMaxWidth(),
                updateCount = { newCount: Int ->
                    actioner(CounterAction.UpdateCount(newCount))
                },
                currentCount = viewState.count
            )
        }
    }
}

@Composable
internal fun ButtonRow(
    modifier: Modifier = Modifier,
    updateCount: (Int) -> Unit,
    currentCount: Int,
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        ButtonBase(text = stringResource(R.string.decrease)) {
            updateCount(currentCount - 1)
        }
        ButtonBase(text = stringResource(id = R.string.increase)) {
            updateCount(currentCount + 1)
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