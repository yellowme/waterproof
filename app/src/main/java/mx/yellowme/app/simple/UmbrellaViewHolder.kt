package mx.yellowme.app.simple

import android.content.Context
import android.view.View
import android.widget.TextView

import mx.yellowme.app.R
import mx.yellowme.waterproof.mvp.WaterproofViewHolder

/**
 * Created by migdonio on 8/2/17.
 */

class UmbrellaViewHolder internal constructor(context: Context?, rootView: View) : WaterproofViewHolder {

    internal var umbrellaColorTextView: TextView
    internal var umbrellaPriceTextView: TextView

    init {
        umbrellaColorTextView = rootView.findViewById(R.id.umbrellaColorTextView)
        umbrellaPriceTextView = rootView.findViewById(R.id.umbrellaPriceTextView)
    }
}
