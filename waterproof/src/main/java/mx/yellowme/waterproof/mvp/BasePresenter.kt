package mx.yellowme.waterproof.mvp

/**
 * Base class for common presenters that frequently uses [BaseView]
 * This class depends on a concrete view that inherits from [BaseView]
 */
abstract class BasePresenter<ConcreteView : BaseView>(
        /**
         * Concrete implementation of BaseView.
         */
        protected var mView: ConcreteView?) {

    /**
     * Helper method to tell the UI stop the loading state and shows a message to the user.
     * @param message to show.
     */
    protected fun notify(message: String) {
        mView?.setProgressIndicator(false)
        mView?.display(message)
    }

}