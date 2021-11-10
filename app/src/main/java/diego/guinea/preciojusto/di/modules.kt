package diego.guinea.preciojusto.di

import diego.guinea.preciojusto.ui.gameLevels.CoinPageViewModel
import diego.guinea.preciojusto.ui.gamePage.GamePageViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

//Modulos de los ViewModel
val viewModelModule = module {
    viewModel { GamePageViewModel() }
    viewModel { CoinPageViewModel() }
}