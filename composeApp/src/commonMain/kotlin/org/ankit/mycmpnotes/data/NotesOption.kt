package org.ankit.mycmpnotes.data

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChecklistRtl
import androidx.compose.material.icons.filled.Draw
import androidx.compose.material.icons.filled.Image
import androidx.compose.material.icons.filled.Mic
import androidx.compose.material.icons.filled.TextFields
import androidx.compose.material.icons.outlined.Brush
import androidx.compose.material.icons.outlined.Check
import androidx.compose.material.icons.outlined.CheckBox
import androidx.compose.material.icons.outlined.CheckBoxOutlineBlank
import androidx.compose.material.icons.outlined.ChecklistRtl
import androidx.compose.material.icons.outlined.Checkroom
import androidx.compose.material.icons.outlined.Draw
import androidx.compose.material.icons.outlined.Image
import androidx.compose.material.icons.outlined.Mic
import androidx.compose.material.icons.outlined.TextFields
import androidx.compose.ui.graphics.vector.ImageVector
import mycmpnotes.composeapp.generated.resources.Res

enum class NotesOption {
    Audio,Images,Drawing,List,Text
}

sealed class NotesOptionList(
    val title: String,
    val icon: ImageVector
) {
    object Audio : NotesOptionList("Audio", Icons.Outlined.Mic)
    object Images : NotesOptionList("Images", Icons.Outlined.Image)
    object Drawing : NotesOptionList("Drawing", Icons.Outlined.Brush)
    object List : NotesOptionList("List", Icons.Outlined.CheckBox)
    object Text : NotesOptionList("Text", Icons.Outlined.TextFields)
}

fun getNotesOptions(): List<NotesOptionList> {
    return listOf(
        NotesOptionList.Audio,
        NotesOptionList.Images,
        NotesOptionList.Drawing,
        NotesOptionList.List,
        NotesOptionList.Text
    )
}


