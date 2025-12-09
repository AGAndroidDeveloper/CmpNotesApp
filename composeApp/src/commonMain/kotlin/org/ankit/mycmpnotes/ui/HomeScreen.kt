package org.ankit.mycmpnotes.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.itemsIndexed
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import org.ankit.mycmpnotes.utill.Constant.dummyNotesData
import org.jetbrains.compose.ui.tooling.preview.Preview
import kotlin.random.Random

@Composable
fun HomeScreen(){
    var notes by remember { mutableStateOf(dummyNotesData()) }
    Scaffold(modifier = Modifier.fillMaxSize(),
        containerColor = Color.Black) { innerPadding ->
        LazyVerticalStaggeredGrid(columns = StaggeredGridCells.Fixed(2), modifier = Modifier.padding(innerPadding),
            verticalItemSpacing = 2.dp,
            horizontalArrangement = Arrangement.spacedBy(2.dp)){
            itemsIndexed(
                items = notes,
                key = { _, note -> note.id }
            ) { index, note ->
                Box(modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(100.dp)
                    .aspectRatio(ratio = Random(1).nextDouble(0.2, 1.8).toFloat())
                    .background(Color(Random(1).nextInt(255), Random(1).nextInt(255), Random(1).nextInt(255)),)
                    , contentAlignment = Alignment.Center
                ){
                    Text(text = "$index, ${note.title}",
                        style = MaterialTheme.typography.bodyMedium)
                }
            }

        }
    }

}

@Composable
@Preview(showBackground = true)
fun HomeScreenPreview(){
    Surface {
        HomeScreen()
    }
}