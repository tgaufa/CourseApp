package com.example.course

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.course.data.DataSource
import com.example.course.model.Topic
import com.example.course.ui.theme.CourseTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CourseTheme {
                CourseApp()
            }
        }
    }
}

@Composable
fun CourseCard(topic: Topic, modifier: Modifier = Modifier) {
    Card(modifier = modifier) {
        Row() {
            Image(
                painter = painterResource(id = topic.imageResourceId),
                contentDescription = null,
                modifier = Modifier
                    .height(68.dp)
                    .width(68.dp),
                contentScale = ContentScale.Crop

            )
            Column(
                modifier = Modifier.padding(start = 16.dp, top = 16.dp, end = 16.dp)) {
                Text(
                    text = stringResource(id = topic.topicNameResourceId),
                    modifier = Modifier.padding(bottom = 8.dp),
                    style = MaterialTheme.typography.bodyMedium
                )
                Row(verticalAlignment = CenterVertically) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_grain),
                        contentDescription = null,
                        modifier = Modifier.padding(end = 8.dp),
                        colorFilter = ColorFilter.tint(LocalContentColor.current)

                    )
                    Text(
                        text = topic.topicNumberResourceId.toString(),
                        style = MaterialTheme.typography.labelMedium
                    )
                }
            }
        }
    }
}

@Composable
fun CourseList(modifier: Modifier = Modifier) {
    LazyVerticalGrid(
        modifier = modifier.padding(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        columns = GridCells.Adaptive(minSize = 150.dp)){
        items(DataSource.topics){
            topic ->
            CourseCard(topic = topic)
        }
    }
}

@Composable
fun CourseApp(){
    CourseList(modifier = Modifier.fillMaxSize())
}
@Preview
@Composable
fun CoursePreview() {
    CourseCard(topic = Topic(R.string.architecture, 12,R.drawable.fashion))
}