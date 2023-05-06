package com.example.mysoothe
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.mysoothe.ui.theme.MySootheTheme
import androidx.compose.ui.unit.dp
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MySootheTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(),
//                        .wrapContentHeight(align = Alignment.CenterVertically),
                    color = MaterialTheme.colors.secondary
                ) {
                    Column(modifier = Modifier) {
                        Column(modifier = Modifier.padding(bottom = 20.dp)) {
                            Box(
                                modifier = Modifier.fillMaxWidth(),
                                contentAlignment = Alignment.Center
                            ) {
                                SearchBar(modifier = Modifier.width(350.dp))
                            }

                        }

                        Row(modifier = Modifier.padding(bottom = 30.dp)) {
                            AlignYourBodyRow()

                        }
                        FavoriteCollectionsGrid()
                    }


                }
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
        AlignYourBodyData(R.mipmap.saber,"Saber"),
        AlignYourBodyData(R.mipmap.archer,"Archer"),
        AlignYourBodyData(R.mipmap.lancer,"Lancer"),
        AlignYourBodyData(R.mipmap.caster,"Caster"),
        AlignYourBodyData(R.mipmap.rider,"Rider"),
        AlignYourBodyData(R.mipmap.assassin,"assassin"),
        AlignYourBodyData(R.mipmap.berserker,"Berserker")
    )
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        //两个组件的间距
        contentPadding = PaddingValues(horizontal = 6.dp),
        //距离最左边的距离
        modifier = modifier
    ) {
        items(alignYourBodyData) { item ->
            AlignYourBodyElement(item.drawable,item.text)
        }
    }
}


@Composable
fun AlignYourBodyElement(text: Int , s: String){
    Column(modifier = Modifier,
        horizontalAlignment = Alignment.CenterHorizontally) {
       Image(painter =painterResource(id = text) , contentDescription =null,
       contentScale = ContentScale.Crop,//不加这句话,图片不是一个圆形
      //contentScale = ContentScale.Crop
      // 用于指定在将图像缩放到与卡片的宽度相同的同时，保留图像中心部分，以便显示一个“切片”效果的图像。
       modifier = Modifier
           .size(120.dp)
           .clip(CircleShape))
        Text(text = s)

    }
}

@Composable
fun FavoriteCollectionsGrid(modifier: Modifier = Modifier){
    var favoriteCollectionsData = listOf(
        AlignYourBodyData(R.mipmap.kuga,"Kuga"),
        AlignYourBodyData(R.mipmap.agtio,"Agito"),
        AlignYourBodyData(R.mipmap.ryuki,"Ryuki"),
        AlignYourBodyData(R.mipmap.faiz,"Faiz"),
        AlignYourBodyData(R.mipmap.blade,"Blade"),
        AlignYourBodyData(R.mipmap.hibiki,"Hibiki"),
        AlignYourBodyData(R.mipmap.kabuto,"Kabuto"),
        AlignYourBodyData(R.mipmap.deno,"Den-o"),
        AlignYourBodyData(R.mipmap.kiva,"Kiva"),
        AlignYourBodyData(R.mipmap.decade,"Decade")
    )

    LazyHorizontalGrid(
        rows = GridCells.Fixed(2),
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier.height(200.dp)
    //若不加最后这句最后界面有点点问题
    ) {
        items(favoriteCollectionsData){
            item->FavoriteCollectionCard(item.drawable,item.text)
        }
    }
}



@Composable
fun FavoriteCollectionCard(
   drawable:Int,text: String
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
                    text = text
                )
            }

        }
    }
}
@Composable
fun SearchBar( modifier: Modifier = Modifier){
    TextField(
        value = "",
        onValueChange = {},
        leadingIcon = { Icon(imageVector = Icons.Default.Search , contentDescription = null)},
        colors = TextFieldDefaults.textFieldColors(backgroundColor = MaterialTheme.colors.background),
        placeholder = {
            Text("Search")
        },
        modifier = modifier
            .width(300.dp)
            .heightIn(min = 20.dp)
    )
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {

}