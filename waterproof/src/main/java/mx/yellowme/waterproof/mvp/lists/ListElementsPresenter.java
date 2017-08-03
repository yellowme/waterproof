package mx.yellowme.waterproof.mvp.lists;

import mx.yellowme.waterproof.mvp.BasePresenter;

public abstract class ListElementsPresenter<Model> extends BasePresenter<ListAllView<Model>> {

    public ListElementsPresenter(
            ListAllView<Model> mView
    ) {
        super(mView);
    }

    public abstract void loadElements(boolean forceUpdate);

    public abstract void open(Model element);
}
