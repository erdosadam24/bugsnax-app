package hu.bme.aut.bugsnaxapp.ui.about

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import hu.bme.aut.bugsnaxapp.R

@Preview
@Composable
fun About() {
    Column (
        modifier = Modifier
            .background(MaterialTheme.colors.background)
            .fillMaxHeight()
    ) {
        ConstraintLayout() {
            val (image, title, version, rights) = createRefs()

            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "logo",
                modifier = Modifier
                    .constrainAs(image) {
                        top.linkTo(parent.top)
                    }
                    .padding(top = 50.dp, start = 50.dp, end = 50.dp)
            )

            Text(
                text = "Bugsnax App",
                style = MaterialTheme.typography.h2,
                //overflow = TextOverflow.Ellipsis,
                //maxLines = 1,
                modifier = Modifier
                    .constrainAs(title) {
                        centerHorizontallyTo(parent)
                        top.linkTo(image.bottom)
                    }
                    .padding(top = 12.dp)
            )

            Text(
                text = "Version 1.0",
                style = MaterialTheme.typography.body1,
                modifier = Modifier
                    .constrainAs(version) {
                        centerHorizontallyTo(parent)
                        top.linkTo(title.bottom)
                    }
                    .padding(top = 16.dp)
            )

            Text(
                text = "All rights reserved",
                style = MaterialTheme.typography.body1,
                modifier = Modifier
                    .constrainAs(rights) {
                        centerHorizontallyTo(parent)
                        top.linkTo(version.bottom)
                    }
                    .padding(top = 8.dp)
            )
        }
    }
}