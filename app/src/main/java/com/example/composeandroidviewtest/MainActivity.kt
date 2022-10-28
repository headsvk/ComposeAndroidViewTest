package com.example.composeandroidviewtest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView
import com.example.composeandroidviewtest.ui.theme.ComposeAndroidViewTestTheme
import com.github.barteksc.pdfviewer.PDFView

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ComposeAndroidViewTestTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Content()
                }
            }
        }
    }
}

@Composable
fun Content() {
    Column(modifier = Modifier.fillMaxSize()) {

        TopAppBar(
            backgroundColor = Color.Green,
        ) {
            Text("ComposeAndroidViewTest")
        }

        AndroidView(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            factory = { context ->
                PDFView(context, null).apply {
                    fromAsset("sample.pdf")
                        .load()
                }
            },
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeAndroidViewTestTheme {
        Content()
    }
}