package com.example.pokedexhacksprint

import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.pokedexhacksprint.detail.presentation.PokeDetailViewModel
import com.example.pokedexhacksprint.detail.presentation.ui.PokeDetailScreen
import com.example.pokedexhacksprint.list.presentation.PokeListViewModel
import com.example.pokedexhacksprint.list.presentation.ui.PokeListScreen

@Composable
fun PokedexApp(
    listViewModel: PokeListViewModel,
    detailViewModel: PokeDetailViewModel
){
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "pokeList"
    ){
        composable(
            route = "pokeList"
        ){
            PokeListScreen(navController, listViewModel)
        }

        composable(
            route = "pokeDetail/{name}",
            arguments = listOf(navArgument("name"){
                type = NavType.StringType
            })

        ){ backStackEntry ->
            val pokeName = requireNotNull(backStackEntry.arguments?.getString("name"))
            PokeDetailScreen(pokeName,navController,detailViewModel)
        }
    }
}