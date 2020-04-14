package com.example.itscoronatime.infoActivity.di

import androidx.lifecycle.ViewModel
import com.example.itscoronatime.infoActivity.data.InfoRepositoryImpl
import com.example.itscoronatime.infoActivity.data.interfaces.InfoRepository
import com.example.itscoronatime.infoActivity.di.scope.InfoScope
import com.example.itscoronatime.infoActivity.domain.InfoInteractorImpl
import com.example.itscoronatime.infoActivity.domain.interfaces.InfoInteractor
import com.example.itscoronatime.infoActivity.presentation.InfoViewModel
import com.example.itscoronatime.viewModelFactory.ViewModelKey
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

@Module
class InfoActivityModule {

    @InfoScope
    @Provides
    fun provideInfoInteractor(infoInteractor: InfoInteractorImpl): InfoInteractor =
        infoInteractor

    @InfoScope
    @Provides
    fun provideInfoRepository(infoRepository: InfoRepositoryImpl)
            : InfoRepository = infoRepository

    @InfoScope
    @Provides
    @IntoMap
    @ViewModelKey(InfoViewModel::class)
    fun provideInfoViewModel(infoInteractor: InfoInteractor, id: Int): ViewModel {
        return InfoViewModel(
            infoInteractor,
            id
        )
    }
}
