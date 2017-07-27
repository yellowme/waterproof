package mx.yellowme.waterproof.mvp;

/**
 * Base class for common presenters that frequently uses {@link BaseView}
 * This class depends on a concrete view that inherits from {@link BaseView}
 */
public abstract class BasePresenter<ConcreteView extends BaseView> {

    /**
     * Concrete implementation of BaseView.
     */
    protected ConcreteView mView;

    public BasePresenter(ConcreteView mView) {
        this.mView = mView;
    }

    /**
     * Helper method to tell the UI stop the loading state and shows a message to the user.
     * @param message to show.
     */
    protected void notify(String message) {
        mView.setProgressIndicator(false);
        mView.display(message);
    }

}