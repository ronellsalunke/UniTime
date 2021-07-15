package ronell.timetable.ui.overview

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.google.accompanist.insets.LocalWindowInsets
import com.google.accompanist.insets.rememberInsetsPaddingValues
import ronell.timetable.data.UniDataObj

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
fun LazyCardList() {
    val data = UniDataObj.uniData
    LazyColumn(
        contentPadding = rememberInsetsPaddingValues(
            insets = LocalWindowInsets.current.systemBars
        )
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
