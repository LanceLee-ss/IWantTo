package com.iwantto.iwantto;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class ImageViewActivity extends AppCompatActivity {

    private ImageView mIv4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imageview);
        mIv4 = (ImageView) findViewById(R.id.iv_4);
        Glide.with(this).load("https://www.baidu.com/img/bd_logo1.png?where=super").into(mIv4);
    }
}
