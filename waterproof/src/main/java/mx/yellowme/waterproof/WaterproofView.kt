package mx.yellowme.waterproof

import android.view.View

import mx.yellowme.waterproof.mvp.BaseView

interface WaterproofView : BaseView {
    val mainLayoutResource: Int
    fun bindViews(root: View)
}
