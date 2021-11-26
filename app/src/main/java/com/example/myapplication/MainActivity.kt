package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toolbar
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.DefaultItemAnimator

import androidx.recyclerview.widget.LinearLayoutManager


class MainActivity : AppCompatActivity() {

    private val itemsList = ArrayList<Movie>()
    var recyclerView: RecyclerView? = null
    lateinit var mAdapter: MoviesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recycler_view)
        mAdapter = MoviesAdapter(itemsList)
        val mLayoutManager: RecyclerView.LayoutManager = LinearLayoutManager(applicationContext)
        recyclerView!!.layoutManager = mLayoutManager
        recyclerView!!.itemAnimator = DefaultItemAnimator()
        recyclerView!!.adapter = mAdapter
        prepareMovieData();

    }


    private fun prepareMovieData() {
        var movie = Movie("Mad Max: Fury Road", "Action & Adventure", "2015")
        itemsList.add(movie)

        movie = Movie("Inside Out", "Animation, Kids & Family", "2015")
        itemsList.add(movie)

        movie = Movie("Star Wars: Episode VII - The Force Awakens", "Action", "2015")
        itemsList.add(movie)

        movie = Movie("Shaun the Sheep", "Animation", "2015")
        itemsList.add(movie)

        movie = Movie("The Martian", "Science Fiction & Fantasy", "2015")
        itemsList.add(movie)

        movie = Movie("Mission: Impossible Rogue Nation", "Action", "2015")
        itemsList.add(movie)

        movie = Movie("Up", "Animation", "2009")
        itemsList.add(movie)

        movie = Movie("Star Trek", "Science Fiction", "2009")
        itemsList.add(movie)

        movie = Movie("The LEGO Movie", "Animation", "2014")
        itemsList.add(movie)

        movie = Movie("Iron Man", "Action & Adventure", "2008")
        itemsList.add(movie)

        movie = Movie("Aliens", "Science Fiction", "1986")
        itemsList.add(movie)

        movie = Movie("Chicken Run", "Animation", "2000")
        itemsList.add(movie)

        movie = Movie("Back to the Future", "Science Fiction", "1985")
        itemsList.add(movie)

        movie = Movie("Raiders of the Lost Ark", "Action & Adventure", "1981")
        itemsList.add(movie)

        movie = Movie("Goldfinger", "Action & Adventure", "1965")
        itemsList.add(movie)

        movie = Movie("Guardians of the Galaxy", "Science Fiction & Fantasy", "2014")
        itemsList.add(movie)

        mAdapter.notifyDataSetChanged()
    }
}