package hr.ferit.sandroblavicki.rma_lv2_zad2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import hr.ferit.sandroblavicki.rma_lv2_zad2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var mainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)
        setUpUi()

    }

    private lateinit var viewPager: ViewPager
    private fun setUpUi() {
        viewPager = mainBinding.vpMainActivity
        viewPager.adapter = FragmentAdapter(supportFragmentManager)
        mainBinding.tabMainActivity.setupWithViewPager(viewPager)

        viewPager?.addOnPageChangeListener(object: ViewPager.OnPageChangeListener {
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
            }

            override fun onPageSelected(position: Int) {
                if (viewPager.currentItem == 0){
                    val adapter = (findViewById<RecyclerView>(R.id.rv_personList).adapter as PersonAdapter)
                    adapter.refreshData(PeopleRepository.getPeople())
                    findViewById<RecyclerView>(R.id.rv_personList).scrollToPosition(adapter.itemCount-1)
                }
            }

            override fun onPageScrollStateChanged(state: Int) {
            }

        })
    }
}