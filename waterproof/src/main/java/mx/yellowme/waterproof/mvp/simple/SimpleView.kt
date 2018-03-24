package mx.yellowme.waterproof.mvp.simple

import mx.yellowme.waterproof.mvp.BaseView

/**
 * Created by migdonio on 7/28/17.
 */

interface SimpleView<in Element> : BaseView {
    fun showElement(element: Element)
    fun setEmptyState(isEmpty: Boolean)
}
