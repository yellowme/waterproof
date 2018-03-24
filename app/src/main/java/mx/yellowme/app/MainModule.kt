package mx.yellowme.app

import dagger.Binds
import dagger.Module
import mx.yellowme.waterproof.di.scope.WpActivityScoped

/**
 * Created by migdonio on 23/03/18.
 */
@Module
abstract class MainModule {

    @WpActivityScoped
    @Binds
    abstract fun dispatchPresenter(presenter: MainPresenter) : MainContract.Presenter

    @WpActivityScoped
    @Binds
    abstract fun dispatchView(view : MainActivity) : MainContract.View
}