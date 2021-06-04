package ronell.timetable

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ronell.timetable.ui.theme.UniTimeTheme


class MainActivity : AppCompatActivity() {
    @ExperimentalFoundationApi
    @ExperimentalAnimationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UniTimeTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    UniTime()
                }
            }
        }
    }
}

@ExperimentalFoundationApi
@ExperimentalAnimationApi
@Composable
fun UniTime() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "UniTime")
                }
            )
        }
    ) { innerPadding ->
        BodyContent(
            Modifier
                .padding(innerPadding)
                .padding(4.dp)
        )
    }
}

@ExperimentalFoundationApi
@ExperimentalAnimationApi
@Composable
fun BodyContent(modifier: Modifier) {

    LazyVerticalGrid(
        cells = GridCells.Fixed(2),
        state = rememberLazyListState(),
        modifier = modifier
            .padding(4.dp)
    ) {

        items(subject.size) {
            Card(
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth(),
                shape = RoundedCornerShape(10.dp),
                backgroundColor = MaterialTheme.colors.secondary,
            ) {
                var expand by remember { mutableStateOf(false) }
                Column(
                    modifier = Modifier
                        .clickable { expand = !expand }
                        .padding(8.dp)

                ) {
                    Text(
                        text = subject[it],
                        Modifier.padding(4.dp),
                        style = MaterialTheme.typography.h6
                    )
                    Text(
                        text = timeslot[it],
                        Modifier.padding(4.dp),
                        style = MaterialTheme.typography.body1
                    )
                    AnimatedVisibility(expand) {
                        Text(
                            text = topics[it],
                            Modifier.padding(4.dp),
                            style = MaterialTheme.typography.body2
                        )
                    }

                }

            }
        }

    }
}


val subject = listOf(
    "Artificial Intelligence", "Enterprise Java", "Microprocessor Architecture"
)
val timeslot = listOf(
    "12 Apr, 10:00 AM", "13 Apr, 11:00 AM", "15 Apr, 12:00 PM"
)
val topics = listOf(
    "First Order Logic, Forward and Backward Chaining",
    "Working with Cookies, Non-Blocking I/O",
    "Introduction to 8085"
)

@ExperimentalFoundationApi
@ExperimentalAnimationApi
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    UniTimeTheme {
        UniTime()
    }
}