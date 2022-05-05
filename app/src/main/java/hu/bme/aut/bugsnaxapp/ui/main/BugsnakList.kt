package hu.bme.aut.bugsnaxapp.ui.main

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.google.accompanist.insets.statusBarsPadding
import hu.bme.aut.bugsnaxapp.model.Bugsnak
import hu.bme.aut.bugsnaxapp.theme.BugsnaxTheme

@Composable
fun BugsnaxList(
    modifier: Modifier = Modifier,
    bugsnax: List<Bugsnak>
) {
    val listState = rememberLazyListState()
    Column(
        modifier = modifier
            .statusBarsPadding()
            .background(MaterialTheme.colors.background)
    ) {
        LazyColumn(
            state = listState,
            contentPadding = PaddingValues(4.dp)
        ) {
            items(
                items = bugsnax,
                itemContent = { bugsnak ->
                    Bugsnak(
                        bugsnak = bugsnak
                    )
                }
            )
        }
    }
}

@Composable
private fun Bugsnak(
    modifier: Modifier = Modifier,
    bugsnak: Bugsnak
) {
    Surface(
        modifier = modifier
            .fillMaxWidth()
            .padding(4.dp),
        color = MaterialTheme.colors.onBackground,
        elevation = 8.dp,
        shape = RoundedCornerShape(8.dp)
    ) {
        ConstraintLayout(
            modifier = Modifier.padding(8.dp)
        ) {
            val (title, content) = createRefs()

            Text(
                modifier = Modifier
                    .constrainAs(title) {
                        //end.linkTo(title.start)
                    }
                    .padding(horizontal = 12.dp),
                text = bugsnak.name,
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.h2
            )

            Text(
                modifier = Modifier
                    .constrainAs(content) {
                        top.linkTo(title.bottom)
                    }
                    .padding(start = 12.dp, top = 4.dp),
                text = bugsnak.location,
                style = MaterialTheme.typography.body2,
            )
        }
    }
}

@Composable
@Preview
private fun BugsnakPreview() {
    BugsnaxTheme(darkTheme = false) {
        Bugsnak(
            bugsnak = Bugsnak.mock()
        )
    }
}