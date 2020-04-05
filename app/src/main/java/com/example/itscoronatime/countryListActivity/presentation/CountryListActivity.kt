package com.example.itscoronatime.countryListActivity.presentation

import android.os.Bundle
import android.util.Log
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.itscoronatime.R
import com.example.itscoronatime.api.ncs.response.CountriesResponse
import com.example.itscoronatime.countryListActivity.presentation.recycler.CountryListAdapter
import com.example.itscoronatime.countryListActivity.presentation.viewModel.CountryListViewModel
import com.example.itscoronatime.countryListActivity.presentation.viewModel.ViewModelFactory
import kotlinx.android.synthetic.main.activity_country_list.*
import kotlinx.android.synthetic.main.activity_info.*

class CountryListActivity : AppCompatActivity() {

    private var adapter: CountryListAdapter? = null
    private var viewModel: CountryListViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_country_list)
        initViewModel()
        setSearchListener()
    }

    fun initViewModel() {
        this.viewModel =
            ViewModelProvider(this, ViewModelFactory()).get(CountryListViewModel::class.java)
        rv_country_list.layoutManager = LinearLayoutManager(this)
        viewModel?.cityList?.observe(this, Observer {
            setAdapter(it)
        })
    }

    private fun setAdapter(list: List<CountriesResponse>) {
        adapter = CountryListAdapter(list) { country ->
            Log.e("CLICKED", "CLICK")
            viewModel?.clickOnView(this, country.countryInfo.id)
        }
        rv_country_list.adapter = adapter
    }

    private fun setSearchListener() {
        sv.setOnQueryTextListener(object : SearchView.OnQueryTextListener {

            override fun onQueryTextChange(s: String): Boolean {
                return true
            }

            override fun onQueryTextSubmit(s: String): Boolean {
                viewModel?.search(this@CountryListActivity, sv.query.toString())
                return true
            }
        })
    }
}
