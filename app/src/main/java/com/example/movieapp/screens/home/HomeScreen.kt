package com.example.movieapp.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.movieapp.MovieRow
import com.example.movieapp.navigation.MovieScreens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController) {
    Scaffold(topBar = {
        TopAppBar(title = {
            Text("Movies")
        }, colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = Color.Magenta))
    }) {
        MainContent(navController = navController, paddingValues = it)
    }
}

@Composable
fun MainContent(
    navController: NavController,
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
                MovieRow(movie = it) { movie ->
                    navController.navigate(route = MovieScreens.DetailsScreen.name+"/$movie")

                }
            }
        }
    }
}