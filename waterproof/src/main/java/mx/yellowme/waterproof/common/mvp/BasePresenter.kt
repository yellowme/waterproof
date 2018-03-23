package mx.yellowme.waterproof.common.mvp

/**
 * Base class for common presenters that frequently uses [BaseView] methods when
 * receives response from a server request [DataCallbacks.BaseCallback].
 * This class depends on a concrete view that inherits from [BaseView]
 * Created by luisburgos on 8/31/16.
 */
abstract class BasePresenter<ConcreteView : BaseView>(
        protected var view: ConcreteView
) : DataCallbacks.BaseCallback {

    /**
     * This method is called when network is unavailable or unreachable.
     * @param error this message depends on the state of network.
     */
    override fun onNetwork(error: String) {
        notifyFailure(error)
    }

    /**
     * This method is called when a server request fails.
     * @param error message return by the server.
     */
    override fun onServer(error: String) {
        notifyFailure(error)
    }

    override fun onAuthentication(error: String) {
        //TODO: Resolve implementation.
        // Now the Dispatch Process cuts unauthenticated requests.
    }

    /**
     * Helper method to tell the UI stop the loading state and shows a message to the userFrom.
     * @param message to show.
     */
    protected fun notifyFailure(message: String) {
        view.setProgress(false)
        view.display(message)
    }

}