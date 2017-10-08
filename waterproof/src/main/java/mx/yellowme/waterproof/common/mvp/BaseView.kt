package mx.yellowme.waterproof.common.mvp

/**
 * Created by luisburgos on 9/12/17.
 */
interface BaseView {

    fun setProgress(active: Boolean)

    fun display(message: String)

    fun display(message: String, listener: (() -> Unit)?, actionTitle: String?)

}