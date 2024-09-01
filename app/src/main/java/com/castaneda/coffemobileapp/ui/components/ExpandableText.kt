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
    textModifier: Modifier = Modifier,
    style: TextStyle = LocalTextStyle.current,
    fontStyle: FontStyle? = null,
    text: String,
    collapsedMaxLine: Int = 3,
    showMoreText: String = "Read More",
    showMoreStyle: SpanStyle = SpanStyle(fontWeight = FontWeight.SemiBold, color = primary, fontFamily = sora, fontSize = 14.sp),
    showLessText: String = " Show Less",
    showLessStyle: SpanStyle = showMoreStyle,
    textAlign: TextAlign? = null,
    fontSize: TextUnit,
    onTextExpanded: () -> Unit,
    onTextCollapsed: () -> Unit
) {
    var isExpanded by remember { mutableStateOf(false) }
    var clickable by remember { mutableStateOf(false) }
    var lastCharIndex by remember { mutableIntStateOf(0) }

    Box(modifier = Modifier.clickable(clickable) {
        isExpanded = !isExpanded
            if (isExpanded) {
                onTextExpanded() // Llamaa la lambda cuando se expande
            } else {
                onTextCollapsed()
                }
        }.then(modifier)
    ) {
        Text(text = buildAnnotatedString {
            if(clickable){
                if(isExpanded){
                    // Display the full text and "Show Less" button when expanded.
                    append(text)
                    withStyle(style = showLessStyle){
                        append(showLessText)
                    }
                }else{
                    // Display truncated text and "Show More" button when collapsed.
                    val adjustText = text.substring(startIndex = 0, endIndex = lastCharIndex)

                        .dropLast(showMoreText.length + 23) //Espacio que tendra entre el final el Read More
                    append(adjustText+".. ")

                    withStyle(style = showMoreStyle){
                        append(showMoreText)
                    }
                }
            }  else{
                // Display the full text when not clickable.
                append(text)
            }
        },
            maxLines = if(isExpanded) Int.MAX_VALUE else 3, //3
            fontStyle = fontStyle,
            // Callback to determine visual overflow and enable click ability.
            onTextLayout = {
                if (!isExpanded && it.hasVisualOverflow) {
                    clickable = true
                    lastCharIndex = it.getLineEnd(collapsedMaxLine -1)
                }
            },
            style = style,
            textAlign = textAlign,
            fontSize = fontSize,
            fontFamily = sora,
            fontWeight = FontWeight.Light,
            color = textgray
        )
    }
}