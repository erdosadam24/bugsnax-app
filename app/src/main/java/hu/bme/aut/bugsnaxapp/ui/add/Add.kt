package hu.bme.aut.bugsnaxapp.ui.add

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import hu.bme.aut.bugsnaxapp.model.Bugsnak

@Composable
fun Add(
    viewModel: AddViewModel,
    bugsnax: SnapshotStateList<Bugsnak>
) {
    var name by remember { mutableStateOf("") }
    var location by remember { mutableStateOf("") }
    val context = LocalContext.current
    val focusManager = LocalFocusManager.current

    Column(
        modifier = Modifier
            .background(MaterialTheme.colors.background)
            .fillMaxHeight()
    ) {
        ConstraintLayout {
            val (nameInput, locationInput, createButton) = createRefs()

            OutlinedTextField(
                value = name,
                onValueChange = { name = it},
                label = { Text("Name")},
                modifier = Modifier
                    .constrainAs(nameInput) {
                        top.linkTo(parent.top)
                    }
                    .padding(16.dp)
                    .fillMaxWidth()
            )

            OutlinedTextField(
                value = location,
                onValueChange = { location = it},
                label = { Text("Location")},
                modifier = Modifier
                    .constrainAs(locationInput) {
                        top.linkTo(nameInput.bottom)
                    }
                    .padding(start = 16.dp, end = 16.dp, bottom = 16.dp)
                    .fillMaxWidth()
            )

            OutlinedButton(
                onClick = {
                    if (name.trim() == "" || location.trim() == "") {
                        Toast.makeText(context,"Please fill out the empty fields!",Toast.LENGTH_SHORT).show()
                    } else {
                        val newBugsnak = viewModel.createBugsnak(name, location)
                        bugsnax.add(newBugsnak)
                        name = ""
                        location = ""
                        Toast.makeText(context,"New Bugsnak added!",Toast.LENGTH_SHORT).show()
                    }
                    focusManager.clearFocus()
                },
                modifier = Modifier
                    .constrainAs(createButton) {
                        centerHorizontallyTo(parent)
                        top.linkTo(locationInput.bottom)
                    }
                    .padding(start = 16.dp, end = 16.dp, bottom = 16.dp)
            ) {
                Text(
                    text = "Create"
                )
            }
        }
    }
}