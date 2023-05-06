package com.example.mysoothe
import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
//import androidx.compose.foundation.lazy.grid.GridCells
//import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
//import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.SnackbarDefaults.backgroundColor
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle.Companion.Italic
import androidx.compose.ui.tooling.preview.Preview
import com.example.mysoothe.ui.theme.MySootheTheme
import androidx.compose.ui.unit.dp
import java.util.*

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MySootheTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(),


                ) {
//                    Column(modifier = Modifier) {
//                        Column(modifier = Modifier) {
//                            Box(
//                                modifier = Modifier
//                                    .fillMaxWidth()
//                                    .padding(top = 15.dp),
//                                contentAlignment = Alignment.Center
//                            ) {
//                                SearchBar(modifier = Modifier.width(350.dp))
//                            }
//                        }
//                        HomeSection("Fate") {
//                            Row(modifier = Modifier) {
//                                AlignYourBodyRow()
//
//                            }
//                        }
//                        HomeSection("Kamen Rider") {
//                            FavoriteCollectionsGrid()
//                        }
                    Column() {

                        Scaffold(bottomBar = { SootheBottomNavigation() }) { paddingValues ->
                            HomeScreen(Modifier.padding(paddingValues))
                        }
                    }


                    }


                }
            }
        }
    }

    @Composable
    fun HomeScreen(modifier: Modifier = Modifier) {
        Surface(
            modifier = Modifier.fillMaxHeight(),
            color = MaterialTheme.colors.secondary
        ) {
            Column(modifier = Modifier) {
                Column(
                    modifier = Modifier
                        .verticalScroll(rememberScrollState())
                        .padding(vertical = 16.dp),
                ) {
                    SearchBar(Modifier.padding(horizontal = 16.dp))
                }
                Column() {
                    HomeSection("Fate") {
                        AlignYourBodyRow()

                    }
                }

                HomeSection("Kamen Rider") {
                    FavoriteCollectionsGrid()
                }
            }
        }

    }

    data class AlignYourBodyData(
        val drawable: Int,
        val text: String
    )

    @Composable
    fun AlignYourBodyRow(
        modifier: Modifier = Modifier
    ) {
        val alignYourBodyData = listOf(
            AlignYourBodyData(R.mipmap.saber, "Saber"),
            AlignYourBodyData(R.mipmap.archer, "Archer"),
            AlignYourBodyData(R.mipmap.lancer, "Lancer"),
            AlignYourBodyData(R.mipmap.caster, "Caster"),
            AlignYourBodyData(R.mipmap.rider, "Rider"),
            AlignYourBodyData(R.mipmap.assassin, "Assassin"),
            AlignYourBodyData(R.mipmap.berserker, "Berserker")
        )
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            //两个组件的间距
            contentPadding = PaddingValues(horizontal = 6.dp),
            //距离最左边的距离
            modifier = modifier
        ) {
            items(alignYourBodyData) { item ->
                AlignYourBodyElement(item.drawable, item.text)
            }
        }
    }

    @Composable
    fun HomeSection(
        title: String,
        modifier: Modifier = Modifier,
        content: @Composable () -> Unit
    ) {
        Column(modifier) {
            Text(
                text = title.uppercase(Locale.getDefault()),
                style = MaterialTheme.typography.h6,
                modifier = Modifier
                    .paddingFromBaseline(top = 40.dp, bottom = 10.dp)
                    .padding(horizontal = 10.dp)
            )
            content()
        }
    }

    @Composable
    fun AlignYourBodyElement(text: Int, s: String) {
        Column(
            modifier = Modifier,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = text), contentDescription = null,
                contentScale = ContentScale.Crop,//不加这句话,图片不是一个圆形
                //contentScale = ContentScale.Crop
                // 用于指定在将图像缩放到与卡片的宽度相同的同时，保留图像中心部分，以便显示一个“切片”效果的图像。
                modifier = Modifier
                    .size(120.dp)
                    .clip(CircleShape)
            )
            Text(
                text = s,
                fontStyle = Italic
            )

        }
    }

    @Composable
    fun FavoriteCollectionsGrid(modifier: Modifier = Modifier) {
        var favoriteCollectionsData = listOf(
            AlignYourBodyData(R.mipmap.kuga, "Kuga"),
            AlignYourBodyData(R.mipmap.agtio, "Agito"),
            AlignYourBodyData(R.mipmap.ryuki, "Ryuki"),
            AlignYourBodyData(R.mipmap.faiz, "Faiz"),
            AlignYourBodyData(R.mipmap.blade, "Blade"),
            AlignYourBodyData(R.mipmap.hibiki, "Hibiki"),
            AlignYourBodyData(R.mipmap.kabuto, "Kabuto"),
            AlignYourBodyData(R.mipmap.deno, "Den-o"),
            AlignYourBodyData(R.mipmap.kiva, "Kiva"),
            AlignYourBodyData(R.mipmap.decade, "Decade")
        )

        LazyHorizontalGrid(
            rows = GridCells.Fixed(2),
            contentPadding = PaddingValues(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(15.dp),
            modifier = modifier.height(215.dp)
            //若不加最后这句最后界面有点点问题
        ) {
            items(favoriteCollectionsData) { item ->
                FavoriteCollectionCard(item.drawable, item.text)
            }
        }
    }


    @Composable
    fun FavoriteCollectionCard(
        drawable: Int, text: String
    ) {
        Surface(
            shape = MaterialTheme.shapes.small,
            modifier = Modifier
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.width(170.dp)
            ) {
                Image(
                    painter = painterResource(drawable),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.size(100.dp)
                )
                Row(modifier = Modifier.padding(start = 5.dp)) {
                    Text(
                        text = text,
                        fontStyle = Italic
                    )
                }
            }

        }
    }

    @Composable
    fun SearchBar(modifier: Modifier = Modifier) {
        TextField(
            value = "",
            onValueChange = {},
            leadingIcon = { Icon(imageVector = Icons.Default.Search, contentDescription = null) },
            colors = TextFieldDefaults.textFieldColors(backgroundColor = MaterialTheme.colors.background),
            placeholder = {
                Text("Search")
            },
            modifier = modifier
                .fillMaxWidth()
                .heightIn(min = 56.dp)
        )
    }


    @Composable
    fun SootheBottomNavigation() {
        BottomNavigation(
            modifier = Modifier,
            backgroundColor = MaterialTheme.colors.secondary
        ) {
            BottomNavigationItem(
                icon = {
                    Icon(
                        imageVector = Icons.Default.Home,
                        contentDescription = null
                    )
                },
                label = {
                    Text("HOME")
                },
                selected = true, onClick = {})
            BottomNavigationItem(
                icon = {
                    Icon(
                        imageVector = Icons.Default.AccountCircle,
                        contentDescription = null
                    )
                },
                label = {
                    Text("PROFILE")
                },
                selected = true, onClick = {})
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        HomeScreen()
    }
