package mx.yellowme.app

import mx.yellowme.waterproof.mvp.BaseView

/**
 * Created by migdonio on 2/03/18.
 */
interface MainContract {
    interface View : BaseView {
        fun displayDummyMessage(message: String?)
    }
    interface Presenter {
        fun getDummyMessage()
    }
}