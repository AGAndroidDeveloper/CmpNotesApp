package org.ankit.mycmpnotes.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.FabPosition
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import org.ankit.mycmpnotes.utill.Constant.dummyNotesData
import org.jetbrains.compose.ui.tooling.preview.Preview
import kotlin.random.Random

@Composable
fun HomeScreen() {
    var notes by remember { mutableStateOf(dummyNotesData()) }
    var clickShowBtn by remember { mutableStateOf(false) }
    val snackBarHostState = remember { SnackbarHostState() }
    val coroutineScope = rememberCoroutineScope()

    Scaffold(
        modifier = Modifier.fillMaxSize().safeDrawingPadding(),
        containerColor = Color.Black,
        floatingActionButton = {
            FloatingActionBtn(clickShowBtn, onNotesTypeClicked = {title ->
                clickShowBtn = false
                coroutineScope.launch {
                    snackBarHostState.showSnackbar(message = title,withDismissAction = true)
                }
            }) {
                clickShowBtn = !clickShowBtn
            }
            coroutineScope.launch {
//                snackBarHostState.showSnackbar(
//                    message = if (clickShowBtn) "Add Note" else "Cancel Note",
//                    withDismissAction = true
//                )
            }
        },
        floatingActionButtonPosition = FabPosition.EndOverlay,
        snackbarHost = {
            SnackbarHost(
                hostState = snackBarHostState)
        }
    ) { innerPadding ->
        Box(modifier = Modifier.fillMaxSize().padding(innerPadding)){
            LazyVerticalStaggeredGrid(
                modifier = Modifier
                    .fillMaxSize(),
                columns = StaggeredGridCells.Adaptive(150.dp), // Reduced width to ensure 2+ columns on phones
                verticalItemSpacing = 4.dp,
                horizontalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                itemsIndexed(
                    items = notes,
                    key = { _, note -> note.id }
                ) { index, note ->
                    // FIX: Use 'index' as the seed so every item gets a unique, stable ratio
                    val randomRatio = remember(index) {
                        Random(index).nextDouble(0.5, 1.2).toFloat()
                    }

                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            // Ensure a minimum height so text doesn't get squashed
                            .heightIn(min = 100.dp)
                            .aspectRatio(randomRatio)
                            .background(
                                color = Color(note.colorHex),
                                shape = RoundedCornerShape(8.dp) // Added shape for better visuals
                            )
                            .padding(12.dp), // Inner padding for text
                        contentAlignment = Alignment.Center
                    ) {
                        Column(
                            modifier = Modifier.fillMaxSize(),
                            verticalArrangement = Arrangement.spacedBy(4.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                text = "${index + 1}. ${note.title}",
                                style = MaterialTheme.typography.titleMedium,
                                color = Color.Black
                            )

                            Text(
                                text = note.content,
                                style = MaterialTheme.typography.bodySmall,
                                color = Color.Black,
                                maxLines = 3 // Prevent overflow if ratio is small
                            )
                        }
                    }
                }
            }

            if(clickShowBtn){
                Box(
                    modifier = Modifier.fillMaxSize()
                        .background(color = if (clickShowBtn) Color.Black.copy(.5f) else Color.Transparent)
                        .clickable(interactionSource = remember { MutableInteractionSource() },
                            indication = null) {
                            clickShowBtn = false
                        }
                )
            }

        }
    }
}

@Composable
@Preview(showBackground = true)
fun HomeScreenPreview() {
    Surface {
        HomeScreen()
    }
}