package mx.yellowme.waterproof.common.mvp

import mx.yellowme.waterproof.common.mvp.BaseView

interface ListAllView<Item> : BaseView {
    fun show(elements: List<Item>)
}