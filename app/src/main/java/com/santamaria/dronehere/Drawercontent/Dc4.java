package com.santamaria.dronehere.Drawercontent;

import android.os.Build;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.santamaria.dronehere.BaseActivity;
import com.santamaria.dronehere.R;

import java.util.List;

public class Dc4 extends BaseActivity {

    List<String> bit;
    ViewPager pager3;
    Dc4Adapter adp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dc4);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(getResources().getColor(R.color.status2));
        }
        Toast.makeText(Dc4.this, "오른쪽으로 넘기세요.", Toast.LENGTH_SHORT).show();
        pager3=(ViewPager)findViewById(R.id.pager3);
        adp=new Dc4Adapter();
        pager3.setAdapter(adp);
        adp.setImage();
    }
}
