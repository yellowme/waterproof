package mx.yellowme.app

import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import mx.yellowme.app.di.DaggerAppComponent

/**
 * Created by migdonio on 23/03/18.
 */
class App : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent
                .builder()
                .application(this)
                .build()
    }
}