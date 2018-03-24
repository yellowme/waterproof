package mx.yellowme.waterproof.mvp

interface WpView {
    fun setProgressIndicator(active: Boolean, blockInteraction: Boolean = false)

    fun display(message: String)

    fun display(message: String, actionText: String, action: () -> Unit)
}
