package mx.yellowme.app.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import mx.yellowme.app.WaterproofApplication
import javax.inject.Singleton

/**
 * Created by migdonio on 23/03/18.
 */
@Singleton
@Component(modules = [
    (AndroidSupportInjectionModule::class),
    (ActivityBindingModule::class),
    (AppModule::class)]
)
interface AppComponent : AndroidInjector<WaterproofApplication> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): AppComponent.Builder

        fun build(): AppComponent
    }
}