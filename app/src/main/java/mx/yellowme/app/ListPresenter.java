package mx.yellowme.app;

import mx.yellowme.waterproof.mvp.lists.ListAllView;
import mx.yellowme.waterproof.mvp.lists.ListElementsPresenter;

public class ListPresenter extends ListElementsPresenter<ListFragment.MyModel> {

    public ListPresenter(ListAllView<ListFragment.MyModel> mView) {
        super(mView);
    }

    @Override
    public void loadElements(boolean forceUpdate) {

    }

    @Override
    public void open(ListFragment.MyModel element) {

    }
}
