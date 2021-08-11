package com.zhang.home

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.ashokvarma.bottomnavigation.BottomNavigationBar
import com.ashokvarma.bottomnavigation.BottomNavigationItem
import com.ashokvarma.bottomnavigation.TextBadgeItem
import com.zhang.lib_core.mvp.view.BaseActivity
import com.zhang.onehome.OneHomeFragment
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : BaseActivity(),BottomNavigationBar.OnTabSelectedListener{
    var index:Int = 0
    var list = mutableListOf<Fragment>()
    override fun getLayoutId(): Int {
        return R.layout.activity_home
    }

    override fun initData(savedInstanceState: Bundle?) {
        act_home_bottom.setTabSelectedListener(this)
            .setActiveColor("#FF0000")
            .setMode(BottomNavigationBar.MODE_FIXED)
            .setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_DEFAULT)
            .setInActiveColor("#000000")
            .setBarBackgroundColor("#FFFFFF")
        var badgeItem = TextBadgeItem()
            .setBorderWidth(2)
            .setText("4")
            .setBackgroundColor(Color.RED)
            .setTextColor("#FFFFFF")
        act_home_bottom.addItem(BottomNavigationItem(R.drawable.onehome,"刷新"))
            .addItem(BottomNavigationItem(R.drawable.kinds,"分类"))
            .addItem(BottomNavigationItem(R.drawable.look,"发现"))
            .addItem(BottomNavigationItem(R.drawable.shopcar,"购物车").setBadgeItem(badgeItem))
            .addItem(BottomNavigationItem(R.drawable.person,"我的")).initialise()
        if (index==0){
            list.add(OneHomeFragment())
            list.add(OneHomeFragment())
            list.add(OneHomeFragment())
            list.add(OneHomeFragment())
            list.add(OneHomeFragment())
            var viewPagerAdapter = ViewPagerAdapter(this.supportFragmentManager, 0, list)
            act_home_vp.adapter = viewPagerAdapter
            index++
        }
    }

    override fun initEvent() {

    }

    override fun releaseResource() {

    }

    override fun onTabSelected(position: Int) {
        act_home_vp.currentItem = position
    }

    override fun onTabUnselected(position: Int) {

    }

    override fun onTabReselected(position: Int) {

    }
}