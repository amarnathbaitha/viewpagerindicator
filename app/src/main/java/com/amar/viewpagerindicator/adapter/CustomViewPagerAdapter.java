package com.amar.viewpagerindicator.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.amar.viewpagerindicator.R;
import com.amar.viewpagerindicator.bean.HotDeal;

import java.util.List;


/**
 * Created by "Amarnath Baitha" on 24/7/17.
 * To set the image and date to the card view.
 */

public class CustomViewPagerAdapter extends PagerAdapter {
    private Context _context;
    private List<HotDeal> hotDealList;
    private LayoutInflater layoutInflater;

    public CustomViewPagerAdapter(Context context, List<HotDeal> hotDealList) {
        this._context = context;
        this.hotDealList = hotDealList;
        this.layoutInflater = (LayoutInflater) _context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return hotDealList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((View) object);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);

    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = layoutInflater.inflate(R.layout.hot_deal_layout, container, false);
        HotDeal mHotDeal = hotDealList.get(position);
        ImageView favoriteIcon = (ImageView) view.findViewById(R.id.hot_deal_favorite);
        TextView hotDealPrice = (TextView) view.findViewById(R.id.hot_deal_price);
        ImageView hotDealFoodImage = (ImageView) view.findViewById(R.id.hot_deal_food_image);
        TextView hotDealFoodName = (TextView) view.findViewById(R.id.hot_deal_food_name);
        TextView hotDealFoodDescription = (TextView) view.findViewById(R.id.hot_deal_food_description);
        //bind value to the View Widgets
        hotDealPrice.setText(mHotDeal.getDealPrice());
        hotDealFoodName.setText(mHotDeal.getDealName());
        hotDealFoodDescription.setText(mHotDeal.getDealDescription());
//        favoriteIcon.setImageResource(mHotDeal.getImageList());
        hotDealFoodImage.setImageResource(mHotDeal.getImageList());
        container.addView(view);
        return view;
    }


}