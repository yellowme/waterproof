package mx.yellowme.app.simple

import mx.yellowme.waterproof.mvp.simple.SimpleAdapter
import mx.yellowme.waterproof.mvp.simple.SimpleWaterproofFragment

/**
 * Created by migdonio on 8/1/17.
 */

class UmbrellaAdapter(
        wpFragment: SimpleWaterproofFragment<*, *>,
        wpViewHolder: UmbrellaViewHolder
) : SimpleAdapter<Umbrella, UmbrellaViewHolder>(wpFragment, wpViewHolder) {

    override fun bindViews(mViewHolder: UmbrellaViewHolder) {
        mViewHolder.umbrellaPriceTextView.text = item!!.price.toString()
        mViewHolder.umbrellaColorTextView.text = item!!.color
    }
}
