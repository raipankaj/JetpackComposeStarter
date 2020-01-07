package com.presentation.composecheck

import android.os.Bundle
import android.util.Log
import android.view.GestureDetector
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.compose.unaryPlus
import androidx.ui.core.Clip
import androidx.ui.core.Text
import androidx.ui.core.dp
import androidx.ui.core.setContent
import androidx.ui.foundation.VerticalScroller
import androidx.ui.foundation.shape.RectangleShape
import androidx.ui.foundation.shape.corner.CutCornerShape
import androidx.ui.foundation.shape.corner.RoundedCornerShape
import androidx.ui.graphics.Color
import androidx.ui.layout.*
import androidx.ui.material.*
import androidx.ui.material.surface.Card
import androidx.ui.res.imageResource
import androidx.ui.tooling.preview.Preview

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MaterialTheme {
                FlexColumn {
                    inflexible {
                        TopAppBar(title = { Text(text = "Sample") })
                    }

                    flexible(flex = 1.0f) {
                        VerticalScroller {
                            ItemList()
                        }
                    }

                    inflexible {
                        BottomBarLayout()
                    }
                }

            }
        }
    }
}

@Preview
@Composable
fun Demo() {

    MaterialTheme {
        FlexColumn {
            inflexible {
                TopAppBar(title = { Text(text = "Sample") })
            }

            flexible(flex = 0.5f) {
                VerticalScroller {
                    ItemList()
                }
            }

            inflexible {
                BottomBarLayout()
            }
        }

    }
}

@Composable
fun ItemList() {
    Column {
        listOf(
            "One",
            "Two",
            "Three",
            "Four",
            "Five",
            "Six",
            "Seven",
            "Eight",
            "Nine",
            "Ten",
            "Eleven",
            "Twelve",
            "Thirteen",
            "Fourteen",
            "Fifteen"
        ).forEach {

            Card(
                elevation = 16.dp,
                shape = CutCornerShape(20),
                modifier = Spacing(8.dp)
            ) {
                Padding(padding = 12.dp) {
                    
                    Container(expanded = true) {
                        Button(text = it,
                            modifier = Flexible(flex = 1.0f, tight = false),
                            style = TextButtonStyle(
                                contentColor = Color.Black
                            ),
                            onClick = {
                                Log.d("DATA", "Clicked on ${it}")
                            })
                    }
                }
            }
        }
    }
}

@Composable
fun DisplayAlert(msg: String) {
    AlertDialog(onCloseRequest = {},
        text = { Text("Alert") },
        title = { Text("Clicked on ${msg}")},
        confirmButton = { Text("Okay")},
        dismissButton = { Text("Cancel")})
}

@Composable
fun BottomBarLayout() {
    BottomAppBar(
        fabConfiguration = BottomAppBar.FabConfiguration(
            cutoutShape = CutCornerShape(24.dp),
            fabPosition = BottomAppBar.FabPosition.Center,
            fab = {
                FloatingActionButton(
                    icon =
                    +imageResource(R.drawable.cake)
                )
            }),
        navigationIcon = {
            AppBarIcon(
                icon = +imageResource(R.drawable.market),
                onClick = {})
        },

        actionData = listOf(
            +imageResource(R.drawable.cherry),
            +imageResource(R.drawable.fries)
        )
    ) { actionImage ->
        AppBarIcon(icon = actionImage,
            onClick = {})
    }
}