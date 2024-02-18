package com.app.assesmenttest.ui.components.textfields

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.sp

@Composable
fun ExtraSmallText(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = Color.Black,
    maxLines: Int = 1
) {
    Text(
        text = text,
        color = color,
        fontSize = 7.sp,
        fontFamily = FontFamily.SansSerif,
        modifier = modifier,
        maxLines = maxLines,
        style = TextStyle(
            platformStyle = PlatformTextStyle(
                includeFontPadding = false
            ),
        )
    )
}

@Composable
fun SmallText(text: String, modifier: Modifier = Modifier, maxLines: Int = 1) {
    Text(
        text = text,
        color = Color.Black,
        fontSize = 13.sp,
        fontFamily = FontFamily.SansSerif,
        modifier = modifier,
        maxLines = maxLines
    )
}

@Composable
fun RegularText(
    text: String, modifier: Modifier = Modifier,
    fontWeight: FontWeight = FontWeight.Normal,
    color: Color = Color.Black
) {
    Text(
        text = text,
        color = color,
        fontSize = 15.sp,
        fontWeight = fontWeight,
        fontFamily = FontFamily.SansSerif,
        modifier = modifier
    )
}

@Composable
fun MediumText(
    text: String,
    color: Color = Color.Black,
    modifier: Modifier = Modifier,
    fontWeight: FontWeight = FontWeight.Normal
) {
    Text(
        text = text,
        color = color,
        fontSize = 17.sp,
        fontWeight = fontWeight,
        fontFamily = FontFamily.SansSerif,
        modifier = modifier
    )
}

@Composable
fun LargeText(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = Color.Black,
    fontWeight: FontWeight = FontWeight.Normal,
    align: TextAlign = TextAlign.Start
) {
    Text(
        text = text,
        color = color,
        fontSize = 19.sp,
        fontFamily = FontFamily.SansSerif,
        modifier = modifier,
        fontWeight = fontWeight,
        overflow = TextOverflow.Ellipsis,
        textAlign = align
    )
}