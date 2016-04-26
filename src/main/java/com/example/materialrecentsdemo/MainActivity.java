package com.example.materialrecentsdemo;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

//com.example.materialrecentsdemo
public class MainActivity extends AppCompatActivity {
    private RecentsList recentsList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recentsList = (RecentsList) findViewById(R.id.recents);
        //设定颜色
        final int[] colors = new int[]{0xff7fffff, 0xffff7fff, 0xffffff7f, 0xff7f7fff, 0xffff7f7f, 0xff7fff7f};
        recentsList.setAdapter(new RecentsAdapter() {
            @Override
            public String getTitle(int position) {
                return "Title" + position;
            }

            @Override
            public View getView(int position) {
                ImageView iv = new ImageView(MainActivity.this);
                iv.setScaleType(android.widget.ImageView.ScaleType.CENTER_CROP);
                iv.setImageResource(R.drawable.pixel01);
                iv.setBackgroundColor(0xffffffff);
                return iv;
            }

            @Override
            public Drawable getIcon(int position) {
                return getResources().getDrawable(R.mipmap.ic_launcher);
            }

            @Override
            public int getHeaderColor(int position) {
                return 0xffffffff;
            }

            @Override
            public int getCount() {
                return 5;
            }
        });
        recentsList.setOnItemClickListener(new RecentsList.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(view.getContext(), "Card " + position + " clicked", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
