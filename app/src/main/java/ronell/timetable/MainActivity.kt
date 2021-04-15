package ronell.timetable

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ronell.timetable.ui.theme.UniTimeTheme


class MainActivity : AppCompatActivity() {
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

@Composable
fun BodyContent(modifier: Modifier) {

    LazyColumn(
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
                Column(
                    modifier = Modifier
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


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    UniTimeTheme {
        UniTime()
    }
}