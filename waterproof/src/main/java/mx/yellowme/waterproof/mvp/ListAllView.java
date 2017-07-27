package mx.yellowme.waterproof.mvp;

import java.util.List;

public interface ListAllView<Element> extends BaseView {
    void showElements(List<Element> elements);
}