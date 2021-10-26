package szeweq.desktopose.combobox

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import szeweq.desktopose.core.*
import szeweq.desktopose.hover.DesktopButton
import szeweq.desktopose.hover.hover

/**
 * A combo box with custom values and labels.
 */
@Composable
fun <T> ComboBox(name: String, setValue: (T) -> Unit, vararg pairs: Pair<String, T>) = ComboBoxLayout(name) {
    val mod = Modifier.hover()
    for ((txt, value) in pairs) {
        ComboBoxItem(txt, setValue.bind(value), mod)
    }
}

/**
 * A combo box with specified values (also used as labels).
 */
@Composable
fun ComboBox(name: String, setValue: (String) -> Unit, values: Iterable<String>) = ComboBoxLayout(name) {
    val mod = Modifier.hover()
    for (txt in values) {
        ComboBoxItem(txt, setValue.bind(txt), mod)
    }
}

@Composable
fun ComboBoxItem(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier,
    contentPadding: PaddingValues = PaddingValues(horizontal = 8.dp)
) = DropdownMenuItem(
    onClick and LocalDismissMethod.current,
    modifier.heightIn(min = 32.dp, max = 32.dp),
    contentPadding = contentPadding,
    content = UseScopeText(text)
)

@Composable
private fun ComboBoxLayout(name: String, content: @Composable ColumnScope.() -> Unit) = Box {
    val menuToggle = rememberInitialState(false)
    val dismiss = menuToggle.bind(false)
    DesktopButton(menuToggle.bind(true), Modifier.heightIn(24.dp), contentPadding = PaddingValues(8.dp, 4.dp)) {
        Text(name, fontSize = 12.sp, letterSpacing = 0.5.sp)
        Icon(Icons.Default.ArrowDropDown, "Dropdown", Modifier.size(16.dp))
    }
    withProviders(
        LocalDismissMethod provides dismiss,
        LocalTextStyle provides LocalTextStyle.current.merge(MaterialTheme.typography.caption)
    ) {
        DropdownMenu(menuToggle.value, dismiss, content = content)
    }
}