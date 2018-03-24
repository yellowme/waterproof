package mx.yellowme.app.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import mx.yellowme.app.MainActivity
import mx.yellowme.app.MainModule

/**
 * Created by migdonio on 23/03/18.
 */
@Module
abstract class ActivityBindingModule {

    @ActivityScoped
    @ContributesAndroidInjector(modules = [MainModule::class])
    abstract fun mainActivity(): MainActivity
}