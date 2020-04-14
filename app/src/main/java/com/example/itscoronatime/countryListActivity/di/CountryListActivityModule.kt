package com.example.itscoronatime.countryListActivity.di

import androidx.lifecycle.ViewModel
import com.example.itscoronatime.app.navigation.Navigator
import com.example.itscoronatime.countryListActivity.data.CountryListRepositoryImpl
import com.example.itscoronatime.countryListActivity.data.interfaces.CountryListRepository
import com.example.itscoronatime.countryListActivity.di.scope.CountryListScope
import com.example.itscoronatime.countryListActivity.domain.CountryListInteractorImpl
import com.example.itscoronatime.countryListActivity.domain.interfaces.CountryListinteractor
import com.example.itscoronatime.countryListActivity.presentation.CountryListViewModel
import com.example.itscoronatime.viewModelFactory.ViewModelKey
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

@Module
class CountryListActivityModule {

    @CountryListScope
    @Provides
    @IntoMap
    @ViewModelKey(CountryListViewModel::class)
    fun provideCountryListViewModel(countryListinteractor: CountryListinteractor, navigator: Navigator): ViewModel {
        return CountryListViewModel(
            countryListinteractor,
            navigator
        )
    }

    @CountryListScope
    @Provides
    fun provideCountryListInteractor(countryListinteractor: CountryListInteractorImpl): CountryListinteractor =
        countryListinteractor

    @CountryListScope
    @Provides
    fun provideRegisterRepository(countryListRepositoryImpl: CountryListRepositoryImpl)
            : CountryListRepository = countryListRepositoryImpl
    }


