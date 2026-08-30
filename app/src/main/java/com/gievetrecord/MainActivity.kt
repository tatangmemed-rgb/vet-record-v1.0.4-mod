package com.gievetrecord

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

private val Teal = Color(0xFF2C8C82)
private val DarkNavy = Color(0xFF071321)
private val CardNavy = Color(0xFF101C31)
private val Orange = Color(0xFFFF7817)
private val Purple = Color(0xFF6862F0)
private val Aqua = Color(0xFF4DBDB4)
private val Pink = Color(0xFFF0184B)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { MaterialTheme { Surface(Modifier.fillMaxSize(), color = DarkNavy) { Dashboard() } } }
    }
}

@Composable
private fun Dashboard() {
    val date = SimpleDateFormat("EEEE, dd MMMM yyyy", Locale("id","ID")).format(Date()).uppercase(Locale("id","ID"))
    Column(Modifier.fillMaxSize().background(DarkNavy).navigationBarsPadding()) {
        Box(Modifier.fillMaxWidth().height(276.dp).clip(RoundedCornerShape(bottomStart=36.dp,bottomEnd=36.dp)).background(Teal).padding(24.dp)) {
            Row(Modifier.fillMaxWidth(), verticalAlignment=Alignment.Top) {
                Box(Modifier.size(112.dp).clip(RoundedCornerShape(56.dp)).background(Color.White).border(3.dp,Color.White,RoundedCornerShape(56.dp)), contentAlignment=Alignment.Center) {
                    Text("🐄🐐", fontSize=29.sp, textAlign=TextAlign.Center)
                }
                Spacer(Modifier.width(18.dp))
                Column(Modifier.weight(1f)) {
                    Text("Selamat Datang  👋", color=Color.White, fontSize=21.sp, fontWeight=FontWeight.Medium)
                    Spacer(Modifier.height(6.dp))
                    Text("drh. Mediarta Kusuma", color=Color.White, fontSize=29.sp, fontWeight=FontWeight.Bold)
                }
                Text("♧", color=Color.White, fontSize=43.sp)
            }
            Box(Modifier.align(Alignment.BottomCenter).fillMaxWidth(.82f).height(64.dp).clip(RoundedCornerShape(36.dp)).border(3.dp,Color.White.copy(.75f),RoundedCornerShape(36.dp)), contentAlignment=Alignment.Center) {
                Text("▣  $date", color=Color.White, fontSize=20.sp, fontWeight=FontWeight.Bold)
            }
        }
        Spacer(Modifier.height(190.dp))
        Row(Modifier.fillMaxWidth().padding(horizontal=28.dp), horizontalArrangement=Arrangement.spacedBy(28.dp)) {
            CardButton("Pencarian","⌕",Orange,Modifier.weight(1f))
            CardButton("Pemilik","🐾",Purple,Modifier.weight(1f))
        }
        Spacer(Modifier.height(28.dp))
        Row(Modifier.fillMaxWidth().padding(horizontal=28.dp), horizontalArrangement=Arrangement.spacedBy(28.dp)) {
            CardButton("Billing","▤",Aqua,Modifier.weight(1f))
            CardButton("Laporan","▥",Pink,Modifier.weight(1f))
        }
        Spacer(Modifier.height(48.dp))
        Box(Modifier.align(Alignment.CenterHorizontally).width(340.dp).height(96.dp).clip(RoundedCornerShape(28.dp)).background(Color.White).clickable { }, contentAlignment=Alignment.Center) {
            Text("＋  Tambah Pemilik", color=Teal, fontSize=23.sp, fontWeight=FontWeight.Bold)
        }
        Spacer(Modifier.weight(1f))
        Row(Modifier.fillMaxWidth().height(142.dp).clip(RoundedCornerShape(topStart=30.dp,topEnd=30.dp)).background(Teal), horizontalArrangement=Arrangement.SpaceEvenly, verticalAlignment=Alignment.CenterVertically) {
            Bottom("♟","Pemilik"); Bottom("▤","Billing"); Bottom("⌕","Cari"); Bottom("▥","Laporan"); Bottom("⚙","Pengaturan")
        }
    }
}

@Composable
private fun CardButton(title:String, icon:String, borderColor:Color, modifier:Modifier) {
    Column(modifier.height(236.dp).clip(RoundedCornerShape(30.dp)).background(CardNavy).border(4.dp,borderColor,RoundedCornerShape(30.dp)).clickable { }, horizontalAlignment=Alignment.CenterHorizontally, verticalArrangement=Arrangement.SpaceBetween) {
        Spacer(Modifier.height(24.dp))
        Text(title,color=Color.White,fontSize=27.sp,fontWeight=FontWeight.Bold)
        Text(icon,color=borderColor,fontSize=57.sp)
        Spacer(Modifier.height(18.dp))
    }
}

@Composable
private fun Bottom(icon:String,label:String) {
    Column(Modifier.width(112.dp),horizontalAlignment=Alignment.CenterHorizontally,verticalArrangement=Arrangement.Center) {
        Text(icon,color=Color.White,fontSize=38.sp)
        Spacer(Modifier.height(6.dp))
        Text(label,color=Color.White,fontSize=17.sp)
    }
}
