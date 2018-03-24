package mx.yellowme.app.simple

import kotlinx.android.parcel.Parcelize
import mx.yellowme.waterproof.mvp.WpModel

/**
 * Created by migdonio on 8/2/17.
 */

@Parcelize
data class Umbrella(var color: String? = null, var price: Double = 0.toDouble()) : WpModel
