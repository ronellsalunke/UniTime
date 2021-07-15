package ronell.timetable

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat
import com.google.accompanist.insets.LocalWindowInsets
import com.google.accompanist.insets.ProvideWindowInsets
import com.google.accompanist.insets.navigationBarsHeight
import com.google.accompanist.insets.rememberInsetsPaddingValues
import com.google.accompanist.insets.ui.Scaffold
import com.google.accompanist.insets.ui.TopAppBar
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import ronell.timetable.data.UniDataObj
import ronell.timetable.ui.theme.UniTimeTheme


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            UniTimeTheme {
                // A surface container using the 'background' color from the theme
                //Surface {
                //    UniTime() }
                ProvideWindowInsets {
                    UniTime()
                }
            }
        }
    }
}

@Composable
internal fun UniTime() {
    val systemUiController = rememberSystemUiController()
    val useDarkIcons = MaterialTheme.colors.isLight

    SideEffect {
        // Update all of the system bar colors to be transparent, and use
        // dark icons if we're in light theme
        systemUiController.setSystemBarsColor(
            color = Color.Transparent,
            darkIcons = useDarkIcons,
        )
    }
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("UniTime") },
                backgroundColor = MaterialTheme.colors.surface.copy(alpha = 0.95f),
                contentPadding = rememberInsetsPaddingValues(
                    LocalWindowInsets.current.statusBars,
                    applyBottom = false,
                ),
                modifier = Modifier.fillMaxWidth()
            )
        },
        bottomBar = {
            // We add a spacer as a bottom bar, which is the same height as
            // the navigation bar
            Spacer(
                Modifier
                    .navigationBarsHeight()
                    .fillMaxWidth()
            )

        },
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

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    UniTimeTheme {
        UniTime()
    }
}