package mx.yellowme.waterproof;

import java.util.List;

public interface ListAllView<Element> extends BaseView {
    void showElements(List<Element> elements);
}