package com.amar.viewpagerindicator.activity;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioGroup;

import com.amar.viewpagerindicator.R;
import com.amar.viewpagerindicator.adapter.CustomViewPagerAdapter;
import com.amar.viewpagerindicator.bean.HotDeal;

import java.util.ArrayList;
import java.util.List;

/**
 *  This class have the viewpage with indicator
 */
public class MainActivity extends AppCompatActivity {

    //amar here
    private static final String TAG = MainActivity.class.getSimpleName();
    private ViewPager mViewPager;
    private CustomViewPagerAdapter mAdapter;
    private Handler mHandler;
    private final int delay = 2000;
    private int mPage = 0;
    private int[] mImageList = new int[]{R.drawable.image1, R.drawable.image2, R.drawable.thumb1, R.drawable.thumb2};


    Runnable runnable = new Runnable() {
        public void run() {
            if (mAdapter.getCount() == mPage) {
                mPage = 0;
            } else {
                mPage++;
            }
            mViewPager.setCurrentItem(mPage, true);
            mHandler.postDelayed(this, delay);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle(getString(R.string.hot_deal_menus));

        final RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radiogroup);
        mViewPager = (ViewPager) findViewById(R.id.hot_deal_view_pager);

        mHandler = new Handler();
        mAdapter = new CustomViewPagerAdapter(getApplicationContext(), getTestData());
        mViewPager.setAdapter(mAdapter);

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                mPage = position;
                switch (position) {
                    case 0:
                        radioGroup.check(R.id.radioButton);
                        break;
                    case 1:
                        radioGroup.check(R.id.radioButton2);
                        break;
                    case 2:
                        radioGroup.check(R.id.radioButton3);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }

    public List<HotDeal> getTestData() {
        List<HotDeal> mTestData = new ArrayList<>();
        mTestData.add(new HotDeal("$42.00", mImageList[0], "Fried Fish with Sauce", "It is a long established fact that a reader will be distracted by the when looking at its layout.It is a long established fact that a reader will be distracted by the when looking at its layout"));
        mTestData.add(new HotDeal("$30.00", mImageList[1], "Rice and Bean with Sauce", "Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC It is a long established fact that a reader will be distracted by the when looking at its layout"));
        mTestData.add(new HotDeal("$23.00", mImageList[2], "Baked Potato with Salad", "There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour It is a long established fact that a reader will be distracted by the when looking at its layout"));

        return mTestData;
    }

    @Override
    protected void onResume() {
        super.onResume();
        mHandler.postDelayed(runnable, delay);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mHandler.removeCallbacks(runnable);
    }
}
