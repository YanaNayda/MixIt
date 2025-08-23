import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.LocalOverscrollConfiguration
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.animateScrollBy
import androidx.compose.foundation.gestures.scrollBy
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
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



