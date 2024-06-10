package com.surendramaran.yolov8tflite

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class Content : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var fab: FloatingActionButton
    private lateinit var searchBar: EditText
    private lateinit var adapter: MyAdapter
    private lateinit var originalList: List<Product>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_content)

        recyclerView = findViewById(R.id.recyclerView)
        searchBar = findViewById(R.id.searchBar)

        // Sample data
        originalList = listOf(
            Product("Banana", R.drawable.banana, 2),
            Product("Orange", R.drawable.orange, 12),
            Product("Broccoli", R.drawable.broccoli, 1),
            Product("Carrot", R.drawable.carrot, 3),
            Product("Avocado", R.drawable.avocado, 2),
            Product("Potato", R.drawable.potato, 12),
            Product("Onion", R.drawable.onion, 1),
            Product("Tomato", R.drawable.tomato, 3),
            Product("Mango", R.drawable.mango, 3),
            Product("Mayonaise", R.drawable.mayonaise, 3),
            Product("Ketchup", R.drawable.ketchup, 2),
            Product("Eggs", R.drawable.eggs, 12),
            Product("Fromage", R.drawable.fromage, 1),
            Product("Melon", R.drawable.melon, 3),
            Product("Mango", R.drawable.mango, 3),
            Product("Strawberry", R.drawable.strawberry, 12)
        )

        // Set up RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = MyAdapter(originalList)
        recyclerView.adapter = adapter

        // Set up search functionality
        searchBar.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                filterItems(s.toString())
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                // Not used
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                // Not used
            }
        })
    }

    private fun filterItems(query: String) {
        val filteredList = originalList.filter { product ->
            product.name.contains(query, ignoreCase = true)
        }
        adapter.updateList(filteredList)
    }
}
