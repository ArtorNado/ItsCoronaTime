package com.example.itscoronatime.countryListActivity.presentation

import android.os.Bundle
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.itscoronatime.R
import com.example.itscoronatime.api.ncs.response.CountriesResponse
import com.example.itscoronatime.app.injector.Injector
import com.example.itscoronatime.countryListActivity.presentation.recycler.CountryListAdapter
import kotlinx.android.synthetic.main.activity_country_list.*
import javax.inject.Inject

class CountryListActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private var viewModel: CountryListViewModel? = null

    private var adapter: CountryListAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_country_list)
        Injector.plusCountryListActivityComponent().inject(this)
        initViewModel()
        setSearchListener()
    }

    override fun onDestroy() {
        super.onDestroy()
        Injector.clearCountryListActivityComponent()
    }

    fun initViewModel() {
        val viewModel by lazy {
            ViewModelProvider(
                this,
                viewModelFactory
            ).get(CountryListViewModel::class.java)
        }
        this.viewModel = viewModel
        rv_country_list.layoutManager = LinearLayoutManager(this)
        viewModel.cityList.observe(this, Observer {
            setAdapter(it)
        })
    }

    private fun setAdapter(list: List<CountriesResponse>) {
        adapter = CountryListAdapter(list) { country ->
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
