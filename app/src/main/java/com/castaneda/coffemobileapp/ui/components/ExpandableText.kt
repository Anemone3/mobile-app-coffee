package com.castaneda.coffemobileapp.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.castaneda.coffemobileapp.ui.theme.primary
import com.castaneda.coffemobileapp.ui.theme.sora
import com.castaneda.coffemobileapp.ui.theme.textgray

@Composable
fun ExpandableText(
    text: String,
    modifier: Modifier = Modifier,
    collapsedMaxLines: Int = 3,
    showMoreText: String = "Read More",
    showLessText: String = "Show Less",
    textStyle: TextStyle = LocalTextStyle.current,
    fontSize: TextUnit = 14.sp,
    fontWeight: FontWeight = FontWeight.Light,
    onToggle: ((Boolean) -> Unit)? = null
) {
    var isExpanded by remember { mutableStateOf(false) }

    Column(modifier = modifier) {
        Text(
            text = text,
            style = textStyle,
            fontSize = fontSize,
            fontWeight = fontWeight,
            maxLines = if (isExpanded) Int.MAX_VALUE else collapsedMaxLines,
            modifier = Modifier.fillMaxWidth()
        )
        Text(
            text = if (isExpanded) showLessText else showMoreText,
            style = textStyle.copy(
                fontSize = fontSize,
                fontWeight = FontWeight.SemiBold,
                color = primary
            ),
            modifier = Modifier
                .clickable {
                    isExpanded = !isExpanded
                    onToggle?.invoke(isExpanded)
                }
                .padding(top = 4.dp)
        )
    }
}
