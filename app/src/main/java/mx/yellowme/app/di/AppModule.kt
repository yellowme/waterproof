package mx.yellowme.app.di

import android.app.Application
import android.content.Context
import dagger.Binds
import dagger.Module

/**
 * Created by migdonio on 23/03/18.
 */
@Module
abstract class AppModule {

    @Binds
    abstract fun bindContext(application : Application) : Context
}