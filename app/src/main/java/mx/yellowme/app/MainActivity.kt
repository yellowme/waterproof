package mx.yellowme.app

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button

import mx.yellowme.app.simple.UmbrellaActivity
import mx.yellowme.waterproof.mvp.activity.BaseActivity

class MainActivity : BaseActivity<MainPresenter>() {
    override val layout: Int
        get() = R.layout.activity_main

    override fun setupActivity() {

    }

    override fun bindViews() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private var example1: Button? = null
    private var example2: Button? = null
    private var example3: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        example1 = findViewById<View>(R.id.example1) as Button

        example2 = findViewById<View>(R.id.example2) as Button
        example2!!.setOnClickListener {
            val intent = Intent().setClass(applicationContext, UmbrellaActivity::class.java)
            startActivity(intent)
        }

        example3 = findViewById<View>(R.id.example3) as Button
    }
}
