package com.example.recycleview

import android.annotation.SuppressLint
import android.content.res.TypedArray
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var rvHeroes: RecyclerView
    private val listHero = ArrayList<Hero>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        listHero.addAll(getListHeroes)
        rvHeroes = findViewById(R.id.rv_heroes)
        rvHeroes.setHasFixedSize(true)
        showRecycleList()
    }

    private val getListHeroes : ArrayList<Hero> get() {
        val dataNames: Array<String> = resources.getStringArray(R.array.data_name)
        val dataDescriptions: Array<String> = resources.getStringArray(R.array.data_description)
//        val dataPhotos: TypedArray = resources.obtainTypedArray(R.array.data_photo)
        val dataPhotos: Array<String> = resources.getStringArray(R.array.data_photo)

        val listHero = ArrayList<Hero>()
        for (i in dataNames.indices){
//            listHero.add(Hero(dataNames[i], dataDescriptions[i], dataPhotos.getResourceId(i, -1)))
            listHero.add(Hero(dataNames[i], dataDescriptions[i], dataPhotos[i]))
        }
        return listHero
    }

    private fun showRecycleList() {
        rvHeroes.layoutManager = LinearLayoutManager(this)
        val listHeroAdapter = ListHeroAdapter(listHero)
        rvHeroes.adapter = listHeroAdapter
        listHeroAdapter.setOnItemClickCallback(object : ListHeroAdapter.OnItemClickCallback {
            override fun onItemClicked(hero: Hero) {
                showSelectedHero(hero)
            }
        })
    }

    private fun showSelectedHero(hero: Hero) {
        Toast.makeText(
            this,
            "Kamu memilih ${hero.name}",
            Toast.LENGTH_SHORT
        ).show()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.action_list -> {
                rvHeroes.layoutManager = LinearLayoutManager(this)
            }
            R.id.action_grid -> {
                rvHeroes.layoutManager = GridLayoutManager(this, 2)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}