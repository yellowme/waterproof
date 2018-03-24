package mx.yellowme.waterproof.di

import android.app.Application
import android.content.Context
import dagger.Binds
import dagger.Module

/**
 * Created by migdonio on 23/03/18.
 */
@Module
abstract class WpAppModule {

    @Binds
    abstract fun bindContext(application : Application) : Context
}