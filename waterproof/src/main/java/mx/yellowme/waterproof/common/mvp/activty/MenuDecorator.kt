package mx.yellowme.waterproof.common.mvp.activty

import android.view.Menu

/**
 * Created by luisburgos on 10/9/17.
 */
interface MenuDecorator {
    var menu: Menu?
    var decorateMenu: (() -> Unit)?
}