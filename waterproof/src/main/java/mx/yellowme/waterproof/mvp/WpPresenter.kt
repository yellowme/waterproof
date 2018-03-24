package mx.yellowme.waterproof.mvp

/**
 * Base class for common presenters that frequently uses [WpView]
 * This class depends on a concrete view that inherits from [WpView]
 */
abstract class WpPresenter<ConcreteView : WpView>(
        /**
         * Concrete implementation of WpView.
         */
        protected var view: ConcreteView?) {

    /**
     * Helper method to tell the UI stop the loading state and shows a message to the user.
     * @param message to show.
     */
    protected fun notify(message: String) {
        view?.setProgressIndicator(false)
        view?.display(message)
    }

}