package com.example.recyclersearch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.Spannable
import android.text.TextWatcher
import android.text.style.ForegroundColorSpan
import androidx.core.content.res.ResourcesCompat
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclersearch.databinding.ActivityMainBinding
import com.example.recyclersearch.model.Item

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: RvAdapter
    private val spanHighLight by lazy {
        ForegroundColorSpan(ResourcesCompat.getColor(resources, R.color.red, null))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        adapter = RvAdapter(ItemStorage.list)
        binding.rv.adapter = adapter
        binding.rv.layoutManager = LinearLayoutManager(this)

        binding.etSearchBar.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                updateSearch()
                highlight()
            }

            override fun afterTextChanged(s: Editable?) {

            }
        })

    }

    private fun highlight() {

        val search = binding.etSearchBar.text.toString()
        adapter.list.forEach { item ->

            item.abbr.getSpans(0, item.abbr.length, ForegroundColorSpan::class.java).forEach {
                item.abbr.removeSpan(it)
            }

            item.name.getSpans(0, item.name.length, ForegroundColorSpan::class.java).forEach {
                item.name.removeSpan(it)
            }

            if (item.abbr.startsWith(search, true)){
                item.abbr.setSpan(spanHighLight, 0, search.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
            }

            if (item.name.contains(search, true)){
                val index = item.name.indexOf(search, 0, true)
                item.name.setSpan(spanHighLight, index, index+search.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
            }

        }

    }

    private fun updateSearch() {
        val search = binding.etSearchBar.text.toString()

        if (search.length == 0){
            adapter.list = ItemStorage.list
        } else {
            adapter.list = ItemStorage.list.filter {
                it.abbr.startsWith(search, true) || it.name.contains(search, true)
            } as ArrayList<Item>
        }
        adapter.notifyDataSetChanged()
    }
}