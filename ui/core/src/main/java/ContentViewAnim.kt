import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.scrollBy
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay


@Composable
fun InfiniteAutoScrollRow(
    modifier: Modifier = Modifier,
    items: List<Int>,
    itemSize: Dp = 120.dp,
    space: Dp = 8.dp,
    speed: Float = 20f,
    side: Boolean
) {
    val listState = rememberLazyListState(Int.MAX_VALUE / 2)
    LaunchedEffect(side, speed, items) {
        while (true) {
            val direction = if (side) 1 else -1
            listState.scrollBy(direction * speed * 0.05f)
            delay(16L)
        }
    }
    LazyRow(
        modifier = modifier,
        state = listState,
        horizontalArrangement = Arrangement.spacedBy(space),
        contentPadding = PaddingValues(horizontal = 16.dp),
        userScrollEnabled = false
    ) {
        items(Int.MAX_VALUE) { index ->
            val item = items[index % items.size]
            Image(
                painter = painterResource(id = item),
                contentDescription = null,
                modifier = Modifier
                    .size(itemSize)
                    .clip(RoundedCornerShape(16.dp))
            )
        }
    }
}



