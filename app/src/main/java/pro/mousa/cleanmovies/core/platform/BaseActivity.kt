package pro.mousa.cleanmovies.core.platform

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import pro.mousa.cleanmovies.R
import kotlinx.android.synthetic.main.toolbar.toolbar
import pro.mousa.cleanmovies.core.extension.inTransaction

abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_layout)
        setSupportActionBar(toolbar)
        addFragment(savedInstanceState)
    }

    override fun onBackPressed() {
        (supportFragmentManager.findFragmentById(R.id.fragmentContainer) as BaseFragment).onBackPressed()
        super.onBackPressed()
    }

    private fun addFragment(savedInstanceState: Bundle?) {
        savedInstanceState ?: supportFragmentManager.inTransaction {
            add(R.id.fragmentContainer, fragment())
        }
    }

    abstract fun fragment(): BaseFragment
}
