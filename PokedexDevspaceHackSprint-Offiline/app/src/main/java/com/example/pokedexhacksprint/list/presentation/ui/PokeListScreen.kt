package com.example.pokedexhacksprint.list.presentation.ui


import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyGridState
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.pokedexhacksprint.R
import com.example.pokedexhacksprint.list.presentation.PokeListViewModel


@Composable
fun PokeListScreen(
    navController: NavHostController,
    viewModel: PokeListViewModel

) {
    val uiPokemons by viewModel.uiPokemons.collectAsState()
    val pokemonFontSolid = FontFamily(Font(R.font.pokemon_solid))
    val pokemonFontHollow = FontFamily(Font(R.font.pokemon_hollow))
    val listState = rememberLazyGridState()
    val searchError by viewModel.searchError.collectAsState()
    var searchQuery by remember { mutableStateOf("") }



    LaunchedEffect(searchQuery) {
        viewModel.searchPokemon(searchQuery)
    }


    LaunchedEffect(listState) {
        snapshotFlow { listState.layoutInfo.visibleItemsInfo.lastOrNull()?.index }
            .collect { lastVisibleItemIndex ->
                if (lastVisibleItemIndex == uiPokemons.list.size - 1) {
                    viewModel.syncWithApi()
                }
            }
    }

    PokemonListContent(
        pokemonFontSolid = pokemonFontSolid,
        pokemonFontHollow = pokemonFontHollow,
        pokemonDto = uiPokemons,
        listState = listState,
        searchError = searchError,
        onSearchQueryChanged = { query ->
            searchQuery = query
        },
        onClick = { itemClicked ->
            navController.navigate(route = "pokeDetail/${itemClicked.name}")
        }
    )
}


@Composable
private fun PokemonListContent(
    pokemonFontSolid: FontFamily,
    pokemonFontHollow: FontFamily,
    pokemonDto: PokemonListUiState,
    listState: LazyGridState,
    searchError: String?,
    onSearchQueryChanged: (String) -> Unit,
    onClick: (PokemonUiData) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFBB484B))
    ) {


        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFFBB484B))
                .height(160.dp)
        ) {
            Text(
                text = "Pokédex",
                fontFamily = pokemonFontSolid,
                style = MaterialTheme.typography.headlineMedium.copy(
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 64.sp,
                    color = Color(0xFFFFCB05)
                ),
                modifier = Modifier
                    .align(Alignment.BottomCenter)
            )
            Text(
                text = "Pokédex",
                fontFamily = pokemonFontHollow,
                style = MaterialTheme.typography.headlineMedium.copy(
                    fontWeight = FontWeight.Bold,
                    fontSize = 64.sp,
                    color = Color(0xFF3466AF)
                ),
                modifier = Modifier
                    .padding(4.dp)
                    .align(Alignment.BottomCenter)
            )
        }

        Spacer(modifier = Modifier.height(17.dp))

        SearchBar(
            hint = "Search",
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)

        ) { query ->
            onSearchQueryChanged(query)
        }


        if (!searchError.isNullOrEmpty()){
            Text(
                text = searchError,
                color = MaterialTheme.colorScheme.error,
                modifier = Modifier.padding(16.dp)
            )
        }


            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(0xFFFFFFFF)),
                contentPadding = PaddingValues(8.dp),
                state = listState
            ) {

                items(pokemonDto.list) { pokemonUiData ->  // Iterando sobre a lista dentro de pokemonDto
                    PokemonItem(
                        pokemonDto = pokemonUiData,
                        onClick = onClick
                    )
                }
            }

    }
}


@Composable
fun PokemonItem(
    pokemonDto: PokemonUiData,
    onClick: (PokemonUiData) -> Unit,
) {

    Card(
        modifier = Modifier
            .padding(8.dp)
            .clickable { onClick.invoke(pokemonDto) }
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(4.dp),
        shape = RoundedCornerShape(
            topStart = 16.dp,
            topEnd = 16.dp,
            bottomStart = 24.dp,
            bottomEnd = 24.dp
        )
    ) {
        Column(
            modifier = Modifier
                .background(Color(0xFFececec))
                .fillMaxWidth()
                .padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            AsyncImage(
                model = pokemonDto.frontFullDefault,
                modifier = Modifier
                    .padding(bottom = 8.dp)
                    .width(120.dp)
                    .height(120.dp),
                contentScale = ContentScale.Crop,
                contentDescription = "${pokemonDto.name} official artwork"
            )
            Text(
                text = pokemonDto.name.replaceFirstChar { it.uppercase() },
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.DarkGray
            )
        }
    }
}




