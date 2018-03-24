package mx.yellowme.app.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import mx.yellowme.app.MainActivity
import mx.yellowme.app.MainModule
import mx.yellowme.waterproof.di.scope.WpActivityScoped

/**
 * Created by migdonio on 23/03/18.
 */
@Module
abstract class ActivityBindingModule {

    @WpActivityScoped
    @ContributesAndroidInjector(modules = [MainModule::class])
    abstract fun mainActivity(): MainActivity
}