package com.example.characterapp.app.ui.compose.screens.simpsons

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.example.characterapp.R
import com.example.characterapp.app.ui.compose.SliceStringFunction.cutString
import com.example.characterapp.common.nav.routes.SimpsonInput


@Composable
fun SimpsonDetailsScreen(simpsonInput: SimpsonInput) {
    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(
            "Name: ${cutString(simpsonInput.firstURL)}",
            modifier = Modifier
                .align(alignment = Alignment.CenterHorizontally)
        )
        ImageWithPlaceholder(
            imageUrl = simpsonInput.icon,
            placeholder = R.drawable.no_image,
            modifier = Modifier
                .align(alignment = Alignment.CenterHorizontally)
        )
        Text(
            "Description: ${simpsonInput.text}",
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier
                .align(alignment = Alignment.CenterHorizontally)

        )
    }
}

@Composable
fun ImageWithPlaceholder(
    imageUrl: String?,
    placeholder: Int,
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier) {
        val painter = rememberAsyncImagePainter(
            ImageRequest.Builder(LocalContext.current).data(data = imageUrl).apply(block = fun ImageRequest.Builder.() {
                placeholder(placeholder)
                crossfade(true)
            }).build()
        )

        Image(
            painter = painter,
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
    }
}