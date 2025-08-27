package components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun NavigateButton(
    text: String? = null,
    @DrawableRes image: Int? = null,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        shape = RoundedCornerShape(50.dp),
        modifier = Modifier.width(180.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.White
        ),
    ) {
        if (text != null) {
            Text(text = text, color = Color.Black, fontSize = 18.sp, fontWeight = FontWeight.Bold)
        }

        image?.let { painterResource(it) }?.let {
            Image(
                painter = it,
                contentDescription = text ?: "button icon"
            )
        }

    }
}
