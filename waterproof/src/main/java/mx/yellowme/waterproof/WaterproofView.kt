package mx.yellowme.waterproof

import android.view.View

import mx.yellowme.waterproof.mvp.WpView

interface WaterproofView : WpView {
    val mainLayoutResource: Int
    fun bindViews(root: View)
}
