package components
import Resources.Icon.cocktail1
import Resources.Icon.cocktail2
import Resources.Icon.logo
import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.ScrollableDefaults
import androidx.compose.foundation.gestures.scrollBy
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay

@Composable
fun TopImages() {
    val images = listOf(cocktail1, logo, cocktail2)
    val middleIndex = Int.MAX_VALUE / 2
    val startIndex = middleIndex - (middleIndex % images.size) + 1
    val listState = rememberLazyListState(initialFirstVisibleItemIndex = startIndex)

    val screenWidth = LocalConfiguration.current.screenWidthDp.dp
    val itemSize = 175.dp
    val horizontalPadding = (screenWidth - itemSize) / 2


    LazyRow(
        state = listState,
        modifier = Modifier.fillMaxWidth(),
        contentPadding = PaddingValues(horizontal = horizontalPadding, vertical = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(Int.MAX_VALUE) { index ->
            val imageRes = images[index % images.size]
            Image(
                painter = painterResource(id = imageRes),
                contentDescription = null,
                modifier = Modifier
                    .size(itemSize)
                    .clip(RoundedCornerShape(16.dp))
            )
        }
    }
}

