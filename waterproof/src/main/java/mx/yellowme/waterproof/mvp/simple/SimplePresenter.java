package mx.yellowme.waterproof.mvp.simple;

import mx.yellowme.waterproof.mvp.BasePresenter;

public abstract class SimplePresenter<Model> extends BasePresenter<SimpleView<Model>> {

    public SimplePresenter(SimpleView<Model> mView) {
        super(mView);
    }

    public abstract void loadElement(boolean forceUpdate);
}
