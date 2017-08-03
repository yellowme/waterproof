package mx.yellowme.waterproof.mvp.simple;

import mx.yellowme.waterproof.mvp.BaseView;

/**
 * Created by migdonio on 7/28/17.
 */

public interface SimpleView<Element> extends BaseView {
    void showElement(Element element);
    void setEmptyState(boolean isEmpty);
}
