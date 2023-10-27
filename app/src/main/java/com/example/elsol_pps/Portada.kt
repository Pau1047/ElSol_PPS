package com.example.elsol_pps

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.rememberLazyStaggeredGridState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Portada(){
    val listState = rememberLazyStaggeredGridState()

    LazyVerticalStaggeredGrid(columns = StaggeredGridCells.Fixed(2), content = listState){

    }

}

data class InfoPortada(
    var imagen: Int,
    var name: String
)

fun getInfoPortada(): List<InfoPortada>{
    return listOf(
        InfoPortada(
            R.drawable.corona_solar,
            "Corona Solar"
        ),
        InfoPortada(
            R.drawable.erupcionsolar,
            "Erupcion Solar"
        ),
        InfoPortada(
            R.drawable.espiculas,
            "Espiculas"
        ),
        InfoPortada(
            R.drawable.filamentos,
            "Filamentos"
        ),
        InfoPortada(
            R.drawable.magnetosfera,
            "Magnetosfera"
        ),
        InfoPortada(
            R.drawable.manchasolar,
            "Mancha Solar"
        )
    )
}

@Composable
fun MyCard(infoPortada: InfoPortada) {
    var extended by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        shape = MaterialTheme.shapes.medium

    ) {
        Column() {

            Image(painter = painterResource(id = infoPortada.imagen), contentDescription = "Imatge",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )

            BottomAppBar {
                Text(text = infoPortada.name)

                DropdownMenu(expanded = extended, onDismissRequest = { extended = !extended}) {
                    DropdownMenuItem(text = { Text(text = "Copiar") }, onClick = { /*TODO*/ }, leadingIcon = { Icon(
                        imageVector = Icons.Filled.Add,
                        contentDescription = "Back"
                    )
                    })
                    DropdownMenuItem(text = { Text(text = "Eliminar") }, onClick = { /*TODO*/ }, leadingIcon = { Icon(
                        imageVector = Icons.Filled.Delete,
                        contentDescription = "Back"
                    )
                    })

                }
            }
        }
    }
}


