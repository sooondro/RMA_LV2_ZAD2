package hr.ferit.sandroblavicki.rma_lv2_zad2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import hr.ferit.sandroblavicki.rma_lv2_zad2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var mainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)
        setUpUi()

    }

    private fun setUpUi() {
        mainBinding.vpMainActivity.adapter = FragmentAdapter(supportFragmentManager)
        mainBinding.tabMainActivity.setupWithViewPager(mainBinding.vpMainActivity)
    }
}