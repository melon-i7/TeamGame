package com.example.melon_i7.teamgame.bus;

import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.melon_i7.teamgame.R;


/**
 *
 */

public class ViewPagerAdapter extends PagerAdapter {
    private int[] resourceId = {R.drawable.bd,R.drawable.wy,R.drawable.small,R.drawable.welcome};
    @Override
    public int getCount() {
        return resourceId.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View itemView = LayoutInflater.from(container.getContext()).inflate(R.layout.item_guide_pager,null);
        ImageView imgMain = (ImageView) itemView.findViewById(R.id.img_item_guide_main);
        imgMain.setBackgroundResource(resourceId[position]);
        container.addView(itemView);
        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
