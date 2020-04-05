package com.example.itscoronatime.countryListActivity.presentation.recycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.itscoronatime.R
import com.example.itscoronatime.api.ncs.response.CountriesResponse
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.country_list_template.view.*

class CountryListViewHolder(
    override val containerView: View,
    private val clickLambda: (CountriesResponse) -> Unit
) : RecyclerView.ViewHolder(containerView), LayoutContainer {

    fun bind(countriesResponse: CountriesResponse) {
        containerView.tv_deaths.text = countriesResponse.country
        containerView.tv_critical.text = countriesResponse.critical.toString()
        itemView.setOnClickListener{
            clickLambda(countriesResponse)
        }
    }

    companion object {

        fun create(parent: ViewGroup, clickLambda: (CountriesResponse) -> Unit) =
            CountryListViewHolder(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.country_list_template,
                    parent,
                    false
                ),
                clickLambda
            )
    }
}
