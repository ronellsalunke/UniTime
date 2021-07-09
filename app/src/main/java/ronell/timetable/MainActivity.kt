package ronell.timetable

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ronell.timetable.data.UniDataObj
import ronell.timetable.ui.theme.UniTimeTheme


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UniTimeTheme {
                // A surface container using the 'background' color from the theme
                Surface {
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
    ) {
        DataCard()
    }
}


@Composable
fun OverviewCard(
    subject: String,
    timeslot: String,
    topics: String,
) {
    Card(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(10.dp),

        ) {
        Column(
            modifier = Modifier.padding(10.dp)

        ) {
            Text(
                text = subject,
                style = MaterialTheme.typography.h6,
                modifier = Modifier.padding(4.dp)
            )
            Text(
                text = timeslot,
                style = MaterialTheme.typography.body1,
                modifier = Modifier.padding(4.dp)
            )
            Text(
                text = topics,
                style = MaterialTheme.typography.body2,
                modifier = Modifier.padding(4.dp)
            )
        }
    }

}

@Composable
fun DataCard() {
    val data = UniDataObj.uniData
    LazyColumn(
        modifier = Modifier.padding(8.dp)
    ) {
        items(data) {
            OverviewCard(
                subject = it.subject,
                timeslot = it.timeslot,
                topics = it.topics
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    UniTimeTheme {
        UniTime()
    }
}