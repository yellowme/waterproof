package mx.yellowme.waterproof.mvp.lists;

import java.util.List;

import mx.yellowme.waterproof.mvp.BaseView;

public interface ListAllView<Element> extends BaseView {
    void showElements(List<Element> elements);
    void setEmptyListState(boolean isEmpty);
}