package com.example.daisongsong.moneytree.modules.welcome;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.daisongsong.moneytree.R;
import com.example.daisongsong.moneytree.modules.BaseActivity;
import com.example.daisongsong.moneytree.modules.main.MainActivity;

/**
 * Created by daisongsong on 2015/11/11.
 */
public class WelcomeActivity extends BaseActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
    }

    @Override
    protected void onResume() {
        super.onResume();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(WelcomeActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, 1 *1000);
    }
}
