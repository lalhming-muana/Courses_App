package com.example.courses_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.courses_app.data.DataSource
import com.example.courses_app.model.Topic
import com.example.courses_app.ui.theme.Courses_AppTheme
import com.example.courses_app.R
import com.example.courses_app.ui.theme.Courses_AppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Courses_AppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TopicList(DataSource.topics)
                }

            }
                // A surface container using the 'background' color from the theme

            }
        }
    }


@Composable
fun Greeting(modifier: Modifier = Modifier) {
    TopicList(DataSource.topics)
}

@Composable
fun TopicCard(topic: Topic, modifier: Modifier = Modifier ){

    Row(){

        Image(
            painter = painterResource(topic.imageRes),
            contentDescription = null,
            modifier = Modifier
                .height(68.dp)
                .width(68.dp)
        )
        Column(){
            Text(
                text = stringResource(topic.name),
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 16.dp, bottom =8.dp )
            )

            Row(verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center){
                Image(
                    painter = painterResource(id = R.drawable.ic_grain),
                    contentDescription = null,
                    modifier = Modifier.padding(start = 16.dp)
                )

                Text(
                    text = topic.availableCourses.toString(),
                    style = MaterialTheme.typography.labelMedium,
                    modifier = Modifier.padding(start = 8.dp)

                )
            }

        }
    }


}

@Composable
fun TopicList( topicList: List<Topic>,modifier: Modifier = Modifier){
    LazyVerticalGrid(modifier = modifier,
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_small)),
        horizontalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_small)),
    ){
        items(DataSource.topics){ item ->
            TopicCard(item)
        }

    }
}


@Preview(showBackground = true)
@Composable
fun TopicPreview() {
    Courses_AppTheme {
        val topic = Topic(R.string.photography, 321, R.drawable.photography)
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TopicCard(topic = topic)
        }
    }
}

/*
@Preview
@Composable
fun CardPreview(){
    Scollable_list_appTheme {

        TopicCard(Topic(R.string.architecture,12, R.drawable.architecture))
    }
    }
    */