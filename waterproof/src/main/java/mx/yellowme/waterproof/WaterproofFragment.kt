package mx.yellowme.waterproof

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

abstract class WaterproofFragment : Fragment(), WaterproofView {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val root = inflater.inflate(mainLayoutResource, container, false)
        setupView(root)
        return root
    }

    open fun setupView(root: View) {
        bindViews(root)
    }

}
