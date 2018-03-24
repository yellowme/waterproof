package mx.yellowme.waterproof.mvp.simple

import mx.yellowme.waterproof.mvp.WpPresenter

abstract class SimplePresenter<Model>(mView: SimpleView<Model>) : WpPresenter<SimpleView<Model>>(mView) {

    abstract fun loadElement(forceUpdate: Boolean)
}
