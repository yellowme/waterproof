package mx.yellowme.app.simple

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View

import mx.yellowme.app.R

class UmbrellaActivity : AppCompatActivity() {

    private var umbrellaFragment: UmbrellaFragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_example2)

        if (findViewById<View>(R.id.fragment_container) != null) {
            if (savedInstanceState != null) {
                return
            }
            umbrellaFragment = UmbrellaFragment()
            umbrellaFragment?.arguments = intent.extras
            supportFragmentManager.beginTransaction()
                    .add(R.id.fragment_container, umbrellaFragment).commit()
        }
    }
}
