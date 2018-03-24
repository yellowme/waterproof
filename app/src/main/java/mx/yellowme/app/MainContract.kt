package mx.yellowme.app

import mx.yellowme.waterproof.mvp.WpView

/**
 * Created by migdonio on 2/03/18.
 */
interface MainContract {
    interface View : WpView {
        fun displayDummyMessage(message: String?)
    }
    interface Presenter {
        fun getDummyMessage()
    }
}