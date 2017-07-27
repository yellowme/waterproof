package mx.yellowme.waterproof.lists;

import java.util.List;

import mx.yellowme.waterproof.BaseView;

public interface ListElementsContract<Model> {

    interface View<Model> extends BaseView {

        void setEmptyListState(boolean isEmpty);

        void showElements(List<Model> elements);

        void showMoreElements(List<Model> elements);

        void showElementDetail(Model elementSnap);

    }

    interface Presenter<Model> {

        void loadElements(boolean forceUpdate);

        void openElement(Model element);

    }
}
