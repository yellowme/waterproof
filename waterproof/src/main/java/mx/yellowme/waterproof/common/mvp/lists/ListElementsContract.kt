package mx.yellowme.waterproof.common.mvp.lists

import mx.yellowme.waterproof.common.mvp.BaseView

interface ListElementsContract {

    interface View<Model> : BaseView {

        fun empty(isEmpty: Boolean)

        fun show(elements: MutableList<Model>)

        fun showMore(elements: MutableList<Model>)

        fun showElement(snap: Model)

    }

    interface Presenter<Model> {

        fun load(forceUpdate: Boolean)

        fun open(element: Model)

        fun loadMore(currentPage: Int)

        fun search(criteria: String)
    }
}