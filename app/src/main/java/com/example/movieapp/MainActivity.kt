package com.example.movieapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.movieapp.ui.theme.MovieAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp {
                MainContent(it)
            }
        }
    }
}


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyApp(content: @Composable (PaddingValues) -> Unit) {
    MovieAppTheme {
        Scaffold(topBar = {
            TopAppBar(title = {
                Text("Movies")
            }, colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = Color.Magenta))
        }) {
            content(it)
        }
    }
}

@Composable
fun MainContent(
    paddingValues: PaddingValues, movieList: List<String> = listOf(
        "Avatar",
        "Avengers",
        "Yesterday",
        "Abbey Roads",
        "The Shawshank Redemption",
        "The Godfather",
        "Titanic",
        "Inception",
        "The Dark Knight",
        "Forrest Gump",
        "Interstellar",
        "Pulp Fiction",
        "The Matrix",
        "Jurassic Park",
        "The Lord of the Rings: The Fellowship of the Ring",
        "Star Wars: Episode IV - A New Hope",
        "The Lion King",
        "Gladiator",
        "The Silence of the Lambs",
        "Schindler's List",
        "Fight Club",
        "The Avengers",
        "The Departed",
        "Toy Story",
        "The Wizard of Oz",
        "Jaws",
        "The Terminator",
        "Back to the Future",
        "E.T. the Extra-Terrestrial",
        "The Sixth Sense",
        "Goodfellas",
        "The Green Mile",
        "The Prestige",
        "The Usual Suspects",
        "The Truman Show",
        "Saving Private Ryan",
        "The Shawshank Redemption",
        "Braveheart",
        "The Departed",
        "The Grand Budapest Hotel",
        "The Godfather: Part II",
        "The Shining",
        "The Sound of Music",
        "The Exorcist",
        "The Social Network",
        "The Princess Bride",
        "The Big Lebowski",
        "The Graduate",
        "The Breakfast Club",
        "The Princess Diaries"
    )

) {
    Column(
        modifier = Modifier
            .padding(12.dp)
            .padding(top = paddingValues.calculateTopPadding())
    ) {
        LazyColumn {
            items(items = movieList) {
                MovieRow(movie = it)
            }
        }
    }
}

@Composable
fun MovieRow(movie: String) {
    Card(
        modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth()
            .height(130.dp),
        shape = RoundedCornerShape(corner = CornerSize(12.dp)),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        )
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Surface(
                modifier = Modifier
                    .padding(12.dp)
                    .size(100.dp),
                shape = RectangleShape,
                shadowElevation = 4.dp
            ) {
                Icon(
                    imageVector = Icons.Default.AccountBox,
                    contentDescription = "Movie Image"
                )
            }
            Text(text = movie)
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApp {
        MainContent(it)
    }
}