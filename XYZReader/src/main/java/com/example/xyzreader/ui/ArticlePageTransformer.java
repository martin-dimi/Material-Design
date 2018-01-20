package com.example.xyzreader.ui;

import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.xyzreader.R;


public class ArticlePageTransformer implements ViewPager.PageTransformer {


    @Override
    public void transformPage(View page, float position) {
        int pageWidth = page.getWidth();

        //-1    left
        //1     right

        if (position < -1 || position > 1)    // This page is way off-screen
            page.setAlpha(1);
        else {

            FloatingActionButton fab = page.findViewById(R.id.share_fab);
            ImageView photo = page.findViewById(R.id.photo);
            TextView body = page.findViewById(R.id.article_body);

            float posAbs = Math.abs(position);

            photo.setTranslationX(-position * (pageWidth / 2));
            photo.setAlpha(1 - posAbs);

            fab.setScaleX(1 - posAbs);
            fab.setScaleY(1 - posAbs);
            fab.setRotation(360 * position);

            body.setTranslationX(-position * (pageWidth / 2));
            body.setAlpha(1 - posAbs);
        }

    }
}
