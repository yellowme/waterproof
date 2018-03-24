package mx.yellowme.app.simple

import mx.yellowme.waterproof.mvp.simple.SimplePresenter
import mx.yellowme.waterproof.mvp.simple.SimpleView

/**
 * Created by migdonio on 8/1/17.
 */

class UmbrellaPresenter(mView: SimpleView<*>) : SimplePresenter<Umbrella>(mView) {

    override fun loadElement(forceUpdate: Boolean) {
        // load by Database or Rest API
        val umbrella = createDummyUmbrella()
        mView!!.showElement(umbrella)
    }

    private fun createDummyUmbrella(): Umbrella {
        val umbrella = Umbrella()
        umbrella.color = "Blue"
        umbrella.price = 239.99

        return umbrella
    }
}
