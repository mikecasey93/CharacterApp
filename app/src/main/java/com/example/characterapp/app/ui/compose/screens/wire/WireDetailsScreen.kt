package com.example.characterapp.app.ui.compose.screens.wire

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.example.characterapp.R
import com.example.characterapp.app.ui.compose.SliceStringFunction.cutString
import com.example.characterapp.common.nav.routes.WireInput

@Composable
fun WireDetailsScreen (wireInput: WireInput) {
    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(
            "${cutString(wireInput.firstURL)}",
            modifier = Modifier
                .align(alignment = Alignment.CenterHorizontally),
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(40.dp))
//        ImageWithPlaceholder(
//            imageUrl = wireInput.icon,
//            placeholder = R.drawable.no_image,
//            modifier = Modifier
//                .align(alignment = Alignment.CenterHorizontally)
//        )
        Text(
            "${wireInput.text}",
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier
                .align(alignment = Alignment.CenterHorizontally),
            fontSize = 20.sp
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