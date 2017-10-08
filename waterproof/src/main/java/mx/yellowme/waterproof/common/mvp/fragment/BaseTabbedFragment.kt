package mx.yellowme.waterproof.common.mvp.fragment

import kotlinx.android.synthetic.main.component_tabbed_fragment.*
import mx.yellowme.waterproof.R
import mx.yellowme.waterproof.common.adapter.BasePagerAdapter
import mx.yellowme.waterproof.common.extensions.makeVisible


abstract class BaseTabbedFragment : BaseFragment() {

    //MARK: Life Cycle

    abstract var pagerAdapter: BasePagerAdapter?

    override fun configureViews() {
        super.configureViews()
        viewPager.makeVisible()
        tabLayout.makeVisible()
        setupViewPager()
    }

    private fun setupViewPager() {
        viewPager.adapter = pagerAdapter
        tabLayout.setupWithViewPager(viewPager)
        //TODO: Add decorator
    }

    override val layout: Int
        get() = R.layout.component_tabbed_fragment
}