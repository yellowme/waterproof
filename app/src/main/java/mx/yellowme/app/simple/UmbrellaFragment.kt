package mx.yellowme.app.simple

import android.view.View

import mx.yellowme.app.R
import mx.yellowme.waterproof.mvp.simple.*
import mx.yellowme.waterproof.mvp.simple.SimplePresenter

/**
 * Created by migdonio on 8/1/17.
 */

class UmbrellaFragment : SimpleWaterproofFragment<Umbrella, UmbrellaViewHolder>() {

    override val presenter: SimplePresenter<Umbrella>
        get() = UmbrellaPresenter(this)

    override val emptyListMessage: String?
        get() = "No hay sombrilla"

    override val mainLayoutResource: Int
        get() = R.layout.fragment_umbrella

    override fun setupAdapter() {
        mAdapter = UmbrellaAdapter(this, mViewHolder)
    }

    override fun getConcreteItemViewHolder(root: View): UmbrellaViewHolder {
        return UmbrellaViewHolder(context, root)
    }

}
