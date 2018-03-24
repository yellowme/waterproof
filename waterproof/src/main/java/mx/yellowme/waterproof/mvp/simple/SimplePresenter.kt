package mx.yellowme.waterproof.mvp.simple

import mx.yellowme.waterproof.mvp.BasePresenter

abstract class SimplePresenter<Model>(mView: SimpleView<Model>) : BasePresenter<SimpleView<Model>>(mView) {

    abstract fun loadElement(forceUpdate: Boolean)
}
