package com.terry.mango_contents

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private val items = mutableListOf<ContentsModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        items.add(
            ContentsModel(
                "https://www.mangoplate.com/restaurants/e93TWOgph-",
                "https://mp-seoul-image-production-s3.mangoplate.com/72269/1755953_1607641409672_14972?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                "삼족"
            )
        )



        val recyclerView = findViewById<RecyclerView>(R.id.rv)
        val rvAdapter = RVAdapter(items, baseContext)
        recyclerView.adapter = rvAdapter

        rvAdapter.itemClick = object : RVAdapter.ItemClick {
            override fun onClick(view: View, position: Int) {
                val intent = Intent(baseContext, ViewActivity::class.java)
                intent.putExtra("url", items[position].url)
                startActivity(intent)
            }

        }

        recyclerView.layoutManager = GridLayoutManager(this, 2)

    }
}