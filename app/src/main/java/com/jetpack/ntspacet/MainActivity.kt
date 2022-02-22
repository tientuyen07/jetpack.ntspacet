package com.jetpack.ntspacet

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.ContentAlpha
import androidx.compose.material.ProvideTextStyle
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.compositeOver
import androidx.compose.ui.tooling.preview.Preview
import com.jetpack.ntspacet.ui.theme.CustomTheme
import com.jetpack.ntspacet.ui.theme.JetpackntspacetTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {


            CustomButton(onClick = {}) {

            }

        }
    }
}

@Composable
fun CustomButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    content: @Composable RowScope.() -> Unit
) {
    Button(
        colors = ButtonDefaults.buttonColors(
            backgroundColor = CustomTheme.colors.component,
            contentColor = CustomTheme.colors.content,
            disabledBackgroundColor = CustomTheme.colors.content
                .copy(alpha = 0.12f)
                .compositeOver(CustomTheme.colors.component),
            disabledContentColor = CustomTheme.colors.content
                .copy(alpha = ContentAlpha.disabled)
        ),
        shape = ButtonShape,
        elevation = ButtonDefaults.elevation(
            defaultElevation = CustomTheme.elevation.default,
            pressedElevation = CustomTheme.elevation.pressed
            /* disabledElevation = 0.dp */
        ),
        onClick = onClick,
        modifier = modifier,
        content = {
            ProvideTextStyle(
                value = CustomTheme.typography.body
            ) {
                content()
            }
        }
    )
}

val ButtonShape = RoundedCornerShape(percent = 50)

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetpackntspacetTheme {
    }
}