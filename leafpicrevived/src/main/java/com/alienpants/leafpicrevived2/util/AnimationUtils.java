package com.alienpants.leafpicrevived2.util;

import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.alienpants.leafpicrevived2.util.preferences.Prefs;

/**
 * Created by dnld on 24/02/18.
 */

public class AnimationUtils {

    public static RecyclerView.ItemAnimator getItemAnimator(RecyclerView.ItemAnimator itemAnimator) {
        if(Prefs.animationsEnabled()) {
            return itemAnimator;
        }
        return null;
    }

    public static ViewPager.PageTransformer getPageTransformer(ViewPager.PageTransformer pageTransformer) {
        if(Prefs.animationsEnabled()) {
            return pageTransformer;
        }
        return null;
    }
}
