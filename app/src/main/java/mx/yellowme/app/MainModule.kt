package mx.yellowme.app

import dagger.Binds
import dagger.Module
import mx.yellowme.app.di.ActivityScoped

/**
 * Created by migdonio on 23/03/18.
 */
@Module
abstract class MainModule {

    @ActivityScoped
    @Binds
    abstract fun dispatchPresenter(presenter: MainPresenter) : MainContract.Presenter

    @ActivityScoped
    @Binds
    abstract fun dispatchView(view : MainActivity) : MainContract.View
}