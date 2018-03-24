package mx.yellowme.app

import android.content.Intent
import kotlinx.android.synthetic.main.activity_main.*

import mx.yellowme.app.simple.UmbrellaActivity
import mx.yellowme.waterproof.mvp.activity.WpActivity

class MainActivity :
        WpActivity<MainPresenter>(),
        MainContract.View {

    override val layout: Int
        get() = R.layout.activity_main

    override fun setupActivity() {

        example2?.setOnClickListener {
            val intent = Intent().setClass(applicationContext, UmbrellaActivity::class.java)
            startActivity(intent)
        }
        presenter?.getDummyMessage()
    }

    override fun displayDummyMessage(message: String?) {
        display(message ?: "Mensaje nullo")
    }
}
