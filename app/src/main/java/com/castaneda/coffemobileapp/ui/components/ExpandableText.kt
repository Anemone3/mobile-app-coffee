package com.castaneda.coffemobileapp.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
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
import androidx.compose.ui.unit.sp
import com.castaneda.coffemobileapp.ui.theme.primary
import com.castaneda.coffemobileapp.ui.theme.sora
import com.castaneda.coffemobileapp.ui.theme.textgray

@Composable
fun ExpandableText(
    modifier: Modifier = Modifier,
    text: String,
    collapsedMaxLine: Int = 3,
    showMoreText: String = "Read More",
    showLessText: String = " Show Less",
    fontSize: TextUnit = 14.sp,
    onTextExpanded: () -> Unit = {},
    onTextCollapsed: () -> Unit = {}
) {
    var isExpanded by remember { mutableStateOf(false) }
    var clickable by remember { mutableStateOf(false) }
    var lastCharIndex by remember { mutableIntStateOf(0) }

    Box(
        modifier = Modifier.clickable(clickable) {
            isExpanded = !isExpanded
            if (isExpanded) {
                onTextExpanded()
            } else {
                onTextCollapsed()
            }
        }.then(modifier)
    ) {
        Text(
            text = buildAnnotatedString {
                if (clickable) {
                    if (isExpanded) {
                        // Texto completo con "Show Less"
                        append(text)
                        withStyle(style = SpanStyle(fontWeight = FontWeight.SemiBold, color = primary, fontFamily = sora, fontSize = 14.sp)) {
                            append(showLessText)
                        }
                    } else {
                        // Texto truncado con "Read More"
                        val safeEndIndex = minOf(lastCharIndex, text.length)
                        val adjustedText = text.substring(0, safeEndIndex)
                        append(adjustedText)

                        if (adjustedText.length > showMoreText.length) {
                            withStyle(style = SpanStyle(fontWeight = FontWeight.SemiBold, color = primary)) {
                                append("... $showMoreText")
                            }
                        }
                    }
                } else {
                    append(text)
                }
            },
            maxLines = if (isExpanded) Int.MAX_VALUE else collapsedMaxLine,
            fontSize = fontSize,
            onTextLayout = { layoutResult ->
                if (!isExpanded && layoutResult.hasVisualOverflow) {
                    clickable = true
                    lastCharIndex = layoutResult.getLineEnd(
                        (collapsedMaxLine - 1).coerceAtMost(layoutResult.lineCount - 1)
                    ).coerceAtMost(text.length)
                }
            },
        )
    }
}
