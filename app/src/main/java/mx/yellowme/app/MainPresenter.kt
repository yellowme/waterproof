package mx.yellowme.app

import mx.yellowme.waterproof.mvp.WpPresenter
import javax.inject.Inject

/**
 * Created by migdonio on 23/03/18.
 */
class MainPresenter @Inject constructor(view: MainContract.View) :
        WpPresenter<MainContract.View>(view),
        MainContract.Presenter {

    override fun getDummyMessage() {
        view?.displayDummyMessage("Works 2")
    }
}