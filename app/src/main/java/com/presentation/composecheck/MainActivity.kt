package com.presentation.composecheck

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.compose.unaryPlus
import androidx.ui.core.Text
import androidx.ui.core.dp
import androidx.ui.core.setContent
import androidx.ui.graphics.Color
import androidx.ui.layout.Column
import androidx.ui.layout.FlexColumn
import androidx.ui.layout.Padding
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

                    expanded(flex = 1.0f) {
                        ItemList()
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

            expanded(flex = 1.0f) {
                ItemList()
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
        listOf("One", "Two", "Three", "Four", "Five").forEach {
            Padding(padding = 12.dp) {
                Button(text = it,
                        style = TextButtonStyle(
                                contentColor = Color.Black
                        ),
                        onClick = {
                            Log.d("DATA", "Clicked on $it")
                        })
            }
        }
    }
}

@Composable
fun BottomBarLayout() {
    BottomAppBar(
            fabConfiguration = BottomAppBar.FabConfiguration(
                    fabPosition = BottomAppBar.FabPosition.Center,
                    fab = {
                        FloatingActionButton(icon =
                        +imageResource(R.drawable.cake))
                    }),
            navigationIcon = {
                AppBarIcon(
                        icon = +imageResource(R.drawable.market),
                        onClick = {})
            },

            actionData = listOf(
                    +imageResource(R.drawable.cherry),
                    +imageResource(R.drawable.fries))
    ) { actionImage -> AppBarIcon(icon = actionImage,
                onClick = {})
    }
}