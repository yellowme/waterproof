package mx.yellowme.waterproof.common.extensions

import android.content.Context
import android.view.View
import android.view.animation.*
import mx.yellowme.waterproof.R

/**
 * Simple animation methods to help UI components smoothly make transitions.
 * This extensions supports: Fade In, Fade Out, Slide Up From Bottom, Slide Down to Bottom.
 * Created by luisburgos on 10/5/16.
 */

//MARK: Common

/**
 * Helper method to add animations to specific view group.
 *
 * @param animations set of animations to be added to the given view group.
 */
fun View.animateViewGroup(vararg animations: Animation) {
    val animationSet = AnimationSet(false)
    for (animation in animations) {
        animationSet.addAnimation(animation)
    }
    animation = animationSet
}

//MARK: Animation Direction Helper

sealed class AnimationDirection {
    class IN : AnimationDirection()
    class OUT : AnimationDirection()
    class UP: AnimationDirection()
    class DOWN: AnimationDirection()
    class SCALE_UP: AnimationDirection()
    class SCALE_DOWN: AnimationDirection()
}

fun AnimationDirection.animation(context: Context? = null): Animation {
    when(this){
        is AnimationDirection.IN -> return AlphaAnimation(0f, 1f)
        is AnimationDirection.OUT -> return AlphaAnimation(1f, 0f)
        is AnimationDirection.UP -> return AnimationUtils.loadAnimation(context, R.anim.bottom_up)
        is AnimationDirection.DOWN -> return AnimationUtils.loadAnimation(context, R.anim.bottom_down)
        is AnimationDirection.SCALE_UP -> return AnimationUtils.loadAnimation(context, R.anim.scale_up)
        is AnimationDirection.SCALE_DOWN -> return AnimationUtils.loadAnimation(context, R.anim.scale_down)
    }
}

//MARK: API

/**
 * This method fades in/out a UI component depending on the direction.
 */
fun View.fade(
        direction: AnimationDirection = AnimationDirection.IN(),
        duration: Int = 2000,
        listener: Animation.AnimationListener? = null
) {
    val fade = direction.animation()

    fade.interpolator = DecelerateInterpolator()
    fade.duration = duration.toLong()

    listener?.let {
        fade.setAnimationListener(it)
    }

    animateViewGroup(fade)
    when(direction){
        is AnimationDirection.IN -> visibility = View.VISIBLE
        is AnimationDirection.OUT -> visibility = View.GONE
    }

}

/**
 * This method slides up a UI component from the bottom screen.
 * The animation has a default duration defined on the XML file.
 *
 * @param context of the caller activity or fragment.
 *
 */
fun View.slide(
        direction: AnimationDirection = AnimationDirection.IN(),
        duration: Int = 2000,
        listener: Animation.AnimationListener? = null,
        context: Context?
) {
    val animation = direction.animation(context)
    animation.duration = duration.toLong()
    listener?.let {
        animation.setAnimationListener(it)
    }

    startAnimation(animation)
    when(direction){
        is AnimationDirection.UP -> visibility = View.VISIBLE
        is AnimationDirection.DOWN -> visibility = View.GONE
    }
}

/**
 * This method scales a UI component.
 * The animation has a default duration defined on the XML file.
 *
 * @param context of the caller activity or fragment.
 *
 */
fun View.scale(
        direction: AnimationDirection = AnimationDirection.SCALE_UP(),
        listener: Animation.AnimationListener? = null,
        context: Context?
) {
    val animation = direction.animation(context)
    listener?.let {
        animation.setAnimationListener(it)
    }

    startAnimation(animation)
    when(direction){
        is AnimationDirection.SCALE_UP -> visibility = View.VISIBLE
        is AnimationDirection.SCALE_DOWN -> visibility = View.GONE
    }
}