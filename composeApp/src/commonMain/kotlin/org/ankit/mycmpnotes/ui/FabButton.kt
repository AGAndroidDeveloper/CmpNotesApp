package org.ankit.mycmpnotes.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.AudioFile
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import org.ankit.mycmpnotes.data.NotesOptionList
import org.ankit.mycmpnotes.data.getNotesOptions
import org.ankit.mycmpnotes.ui.theme.Primary
import org.jetbrains.compose.ui.tooling.preview.Preview


@Composable
fun FloatingActionBtn(
    clickShowBtn: Boolean,
    onNotesTypeClicked: (String) -> Unit,
    onClick: () -> Unit
) {
    val animatedRotation: Float by animateFloatAsState(
        if (clickShowBtn) 45F else 0F,
        label = "animatedRotation"
    )

    Column(
        horizontalAlignment = Alignment.End,
        verticalArrangement = Arrangement.spacedBy(7.dp)
    ) {
        AnimatedVisibility(clickShowBtn) {
            Column(
                modifier = Modifier, verticalArrangement = Arrangement.spacedBy(4.dp),
                horizontalAlignment = Alignment.End
            ) {
                getNotesOptions().forEach { notesOption ->
                    NotesOptionChip(notesOption = notesOption) {
                        onNotesTypeClicked(notesOption.title)
                    }
                }
            }
        }

        FloatingActionButton(
            onClick = onClick,
            containerColor = Primary,
            shape = RoundedCornerShape(13.dp)
        ) {
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = "Add Note",
                tint = Color.White,
                modifier = Modifier.rotate(animatedRotation)
            )
        }
    }


}

@Composable
fun NotesOptionChip(notesOption: NotesOptionList, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .wrapContentSize()
            .clip(RoundedCornerShape(50.dp))       // 👈 IMPORTANT
            .background(
                color = Color(0xFFAD2690),
                shape = RoundedCornerShape(50.dp)
            )
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = ripple(
                    bounded = true,               // 👈 makes ripple respect shape
                ),
                onClick = onClick
            )
            .padding(10.dp),
        horizontalArrangement = Arrangement.spacedBy(2.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = notesOption.icon,
            contentDescription = notesOption.title,
            tint = Color.White
        )
        Text(text = notesOption.title, color = Color.White)
    }
}


@Composable
@Preview(showBackground = true)
fun FabPreview() {
    Surface {
        FloatingActionBtn(clickShowBtn = true,{}) {}
    }

}