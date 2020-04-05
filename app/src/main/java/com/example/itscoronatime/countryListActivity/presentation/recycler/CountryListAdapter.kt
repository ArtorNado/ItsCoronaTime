package com.example.itscoronatime.countryListActivity.presentation.recycler

import android.util.Log
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.itscoronatime.api.ncs.response.CountriesResponse

class CountryListAdapter(
    private var country: List<CountriesResponse>,
    private var clickLambda: (CountriesResponse) -> Unit
) : ListAdapter<CountriesResponse, CountryListViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryListViewHolder =
        CountryListViewHolder.create(parent, clickLambda)

    override fun getItemCount(): Int = country.size

    override fun onBindViewHolder(holder: CountryListViewHolder, position: Int) {
        Log.e("SIZEE", country.size.toString())
        holder.bind(country[position])
    }

    private class DiffCallback : DiffUtil.ItemCallback<CountriesResponse>() {

        override fun areItemsTheSame(oldItem: CountriesResponse, newItem: CountriesResponse)
                : Boolean = oldItem.country == oldItem.country

        override fun areContentsTheSame(oldItem: CountriesResponse, newItem: CountriesResponse)
                : Boolean = oldItem == newItem
    }

}
