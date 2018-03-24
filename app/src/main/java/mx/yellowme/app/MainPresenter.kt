package mx.yellowme.app

import mx.yellowme.waterproof.mvp.BasePresenter
import javax.inject.Inject

/**
 * Created by migdonio on 23/03/18.
 */
class MainPresenter @Inject constructor(view: MainContract.View) :
        BasePresenter<MainContract.View>(view),
        MainContract.Presenter {

    override fun getDummyMessage() {
        view?.display("Works 1")
        view?.displayDummyMessage("Works 2")
    }
}