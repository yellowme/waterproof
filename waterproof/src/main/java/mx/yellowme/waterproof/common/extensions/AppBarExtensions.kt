package mx.yellowme.waterproof.common.extensions

import android.support.design.widget.AppBarLayout
import android.support.design.widget.CoordinatorLayout
import android.util.Log

fun AppBarLayout.toggleDragBehavior(canDrag: Boolean) {
    layoutParams?.let {
        val params = it as CoordinatorLayout.LayoutParams
        val behavior = params.behavior as? AppBarLayout.Behavior ?: AppBarLayout.Behavior()
        with(behavior) {
            draggable(canDrag)
            params.behavior = this
            invalidate()
        }
    }
}

fun AppBarLayout.Behavior.draggable(canDrag: Boolean ){
    setDragCallback(object : AppBarLayout.Behavior.DragCallback() {
        override fun canDrag(appBarLayout: AppBarLayout): Boolean {
            return canDrag
        }
    })
}

abstract class AppBarStateChangeListener : AppBarLayout.OnOffsetChangedListener {

    enum class State {
        EXPANDED,
        COLLAPSED,
        IDLE
    }

    private var mCurrentState = State.IDLE

    override fun onOffsetChanged(appBarLayout: AppBarLayout, i: Int) {
        Log.d(javaClass.simpleName, "Offset changed to $i")
        if (i == 0) {
            if (mCurrentState != State.EXPANDED) {
                onStateChanged(appBarLayout, State.EXPANDED)
            }
            mCurrentState = State.EXPANDED
        } else if (Math.abs(i) >= appBarLayout.totalScrollRange) {
            if (mCurrentState != State.COLLAPSED) {
                onStateChanged(appBarLayout, State.COLLAPSED)
            }
            mCurrentState = State.COLLAPSED
        } else {
            if (mCurrentState != State.IDLE) {
                onStateChanged(appBarLayout, State.IDLE)
            }
            mCurrentState = State.IDLE
        }
    }

    abstract fun onStateChanged(appBarLayout: AppBarLayout, state: State)
}