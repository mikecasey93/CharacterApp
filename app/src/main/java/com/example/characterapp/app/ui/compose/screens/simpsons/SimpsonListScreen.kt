package com.example.characterapp.app.ui.compose.screens.simpsons

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.test.ext.junit.rules.activityScenarioRule
import com.example.characterapp.app.model.Simpson
import com.example.characterapp.app.model.SimpsonListModel
import com.example.characterapp.app.ui.compose.SliceStringFunction.cutString
import com.example.characterapp.app.ui.uiaction.simpson.SimpsonListAction
import com.example.characterapp.app.ui.uiaction.simpson.SimpsonListSingleEvent
import com.example.characterapp.app.ui.viewmodel.SimpsonListViewModel
import com.example.characterapp.common.state.CommonScreen
import kotlinx.coroutines.flow.collectLatest

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SimpsonListScreen(
    viewModel: SimpsonListViewModel,
    navController: NavController
) {
    LaunchedEffect(Unit) {
        viewModel.submitAction(SimpsonListAction.Load)
    }
    var text by remember { mutableStateOf("") }
    var active by remember { mutableStateOf(false) }

    viewModel.uiStateFlow.collectAsState().value.let { state ->
        CommonScreen(state = state) {
            Column {
                SearchBar(
                    modifier = Modifier.fillMaxWidth(),
                    query = text,
                    onQueryChange = {
                        text = it
                    },
                    onSearch =  {
                        active = false
                    },
                    active = active,
                    onActiveChange = {
                        active = it
                    },
                    placeholder = {
                        Text(text = "Search")
                    },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = "Search Icon"
                        )
                    }
                ) {
                    
                }
                SimpsonList(it) { item ->
                    viewModel.submitAction(
                        SimpsonListAction.SimpsonItemClick(
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
                    is SimpsonListSingleEvent.GoToDetailsScreen -> {
                        navController.navigate(it.route)
                    }
                }
            }
        }
}
    @Composable
    fun SimpsonList(
        listModel: SimpsonListModel,
        onItemClick: (Simpson) -> Unit,
    ) {
        LazyColumn(
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.fillMaxSize()
        ) {
            items(listModel.simpsons) { simpson ->
                SimpsonItem(simpson = simpson, onItemClick = onItemClick)
            }
        }
    }


    @Composable
    fun SimpsonItem(simpson: Simpson, onItemClick: (Simpson) -> Unit) {
        Card(
            elevation = CardDefaults.cardElevation(4.dp),
            modifier = Modifier
                .fillMaxWidth()
                .clickable { onItemClick(simpson) }
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text("${cutString(simpson.firstUrl)}")
            }
        }
    }
