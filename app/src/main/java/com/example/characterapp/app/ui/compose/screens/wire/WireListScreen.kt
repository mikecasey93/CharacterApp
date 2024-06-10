package com.example.characterapp.app.ui.compose.screens.wire

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.characterapp.app.model.Wire
import com.example.characterapp.app.model.WireListModel
import com.example.characterapp.app.ui.compose.SliceStringFunction.cutString
import com.example.characterapp.app.ui.uiaction.wire.WireListAction
import com.example.characterapp.app.ui.uiaction.wire.WireListSingleEvent
import com.example.characterapp.app.ui.viewmodel.WireListViewModel
import com.example.characterapp.common.state.CommonScreen
import kotlinx.coroutines.flow.collectLatest

@Composable
fun WireListScreen(
    viewModel: WireListViewModel,
    navController: NavController
) {
    LaunchedEffect(Unit) {
        viewModel.submitAction(WireListAction.Load)
    }

    viewModel.uiStateFlow.collectAsState().value.let { state ->
        CommonScreen(state = state) {
            Column {
                WireList(it) { item ->
                    viewModel.submitAction(
                        WireListAction.WireItemClick(
                            item.firstUrl,
                            item.icon,
                            item.text
                        )
                    )
                }
            }
        }
    }

    LaunchedEffect(Unit) {
        viewModel.singleEventFlow.collectLatest {
            when (it) {
                is WireListSingleEvent.GoToDetailsScreen -> {
                    navController.navigate(it.route)
                }
            }
        }
    }
}
@Composable
fun WireList(
    listModel: WireListModel,
    onItemClick: (Wire) -> Unit,
) {
    LazyColumn(
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier.fillMaxSize()
    ) {
        items(listModel.wires) { wire ->
            WireItem(wire = wire, onItemClick = onItemClick)
        }
    }
}


@Composable
fun WireItem(wire: Wire, onItemClick: (Wire) -> Unit) {
    Card(
        elevation = CardDefaults.cardElevation(4.dp),
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onItemClick(wire) }
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text("Name: ${cutString(wire.firstUrl)}")
        }
    }
}
