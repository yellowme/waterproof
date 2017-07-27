package mx.yellowme.waterproof.lists;

import mx.yellowme.waterproof.BasePresenter;

public class ListElementsPresenter<Model>
        extends BasePresenter<ListElementsContract.View<Model>>
        implements ListElementsContract.Presenter<Model> {

    public ListElementsPresenter(
            ListElementsContract.View<Model> mView
    ) {
        super(mView);
    }

    @Override
    public void loadElements(boolean forceUpdate) {

    }

    @Override
    public void openElement(Model element) {
        mView.showElementDetail(element);
    }


}
