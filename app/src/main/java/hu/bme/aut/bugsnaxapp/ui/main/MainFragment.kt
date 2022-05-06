package hu.bme.aut.bugsnaxapp.ui.main

import androidx.annotation.StringRes
import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.NoteAdd
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.google.accompanist.insets.navigationBarsHeight
import com.google.accompanist.insets.navigationBarsPadding
import hu.bme.aut.bugsnaxapp.model.Bugsnak
import hu.bme.aut.bugsnaxapp.theme.purple200
import hu.bme.aut.bugsnaxapp.R
import hu.bme.aut.bugsnaxapp.ui.about.About
import hu.bme.aut.bugsnaxapp.ui.add.Add
import hu.bme.aut.bugsnaxapp.ui.add.AddViewModel

@Composable
fun MainFragment(
    viewModel: MainViewModel,
    addViewModel: AddViewModel
) {
    val bugsnax: List<Bugsnak> = viewModel.getBugsnax()
    val selectedTab = NavigationTab.getTabFromResource(viewModel.selectedTab.value)
    val tabs = NavigationTab.values()

    ConstraintLayout {
        val (body, progress) = createRefs()
        Scaffold(
            backgroundColor = Color.White,
            topBar = { BugsnakAppBar() },
            modifier = Modifier.constrainAs(body) {
                top.linkTo(parent.top)
            },
            bottomBar = {
                BottomNavigation(
                    backgroundColor = purple200,
                    modifier = Modifier
                        .navigationBarsHeight(56.dp)
                ) {
                    tabs.forEach { tab ->
                        BottomNavigationItem(
                            icon = { Icon(imageVector = tab.icon, contentDescription = null)},
                            label = { Text(text = stringResource(tab.title), color = Color.White)},
                            selected = tab == selectedTab,
                            onClick = { viewModel.selectTab(tab.title) },
                            selectedContentColor = LocalContentColor.current,
                            unselectedContentColor = LocalContentColor.current,
                            modifier = Modifier.navigationBarsPadding()
                        )
                    }
                }
            }
        ) { innerPadding ->
            val modifier = Modifier.padding(innerPadding)
            Crossfade(selectedTab) { destination ->
                when (destination) {
                    NavigationTab.HOME -> BugsnaxList(modifier, bugsnax)
                    NavigationTab.ABOUT -> About()
                    NavigationTab.ADD -> Add(addViewModel)
                    else -> BugsnaxList(modifier, bugsnax)
                }
            }
        }
    }
}

@Preview
@Composable
private fun BugsnakAppBar() {
    TopAppBar(elevation = 6.dp,
    backgroundColor = purple200,
    modifier = Modifier.height(58.dp)
    ) {
        Text(
            modifier = Modifier
                .padding(8.dp)
                .align(Alignment.CenterVertically),
            text = stringResource(R.string.app_name),
            color = Color.White,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

enum class NavigationTab(
    @StringRes val title: Int,
    val icon: ImageVector
    ) {
    HOME(R.string.menu_home, Icons.Filled.Home),
    ADD(R.string.menu_add, Icons.Filled.NoteAdd),
    ABOUT(R.string.menu_about, Icons.Filled.Info);

    companion object {
        fun getTabFromResource(@StringRes resource: Int): NavigationTab {
            return when (resource) {
                R.string.menu_about -> ABOUT
                R.string.menu_add -> ADD
                else -> HOME
            }
        }
    }
}