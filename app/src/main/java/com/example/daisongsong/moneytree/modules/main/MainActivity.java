package com.example.daisongsong.moneytree.modules.main;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.daisongsong.moneytree.Constant;
import com.example.daisongsong.moneytree.R;
import com.example.daisongsong.moneytree.modules.BaseActivity;
import com.example.daisongsong.moneytree.modules.main.time.TimeAccountTreeView;
import com.example.daisongsong.moneytree.modules.newaccount.AddAccountActivity;

/**
 * Created by daisongsong on 2015/11/11.
 */
public class MainActivity extends BaseActivity implements View.OnClickListener {
    private TextView mTextViewAddNewAccount;
    private TimeAccountTreeView mTimeAccountTreeView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTimeAccountTreeView = (TimeAccountTreeView) findViewById(R.id.mTimeAccountTreeView);
        mTextViewAddNewAccount = (TextView) findViewById(R.id.mTextViewAddNewAccount);
        mTextViewAddNewAccount.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.mTextViewAddNewAccount: {
                startActivityForResult(new Intent(this, AddAccountActivity.class), Constant
                        .REQUEST_CODE_ADD_NEW_ACCOUNT);
                break;
            }
            default:
                break;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        startAnimator();
    }

    @Override
    protected void onPause() {
        stopAnimator();
        super.onPause();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case Constant.REQUEST_CODE_ADD_NEW_ACCOUNT: {
                if (resultCode == RESULT_OK) {
                    mTimeAccountTreeView.requestFirstPage();
                }
                break;
            }
        }
    }

    private void startAnimator() {
        long duration = 2 * 1000;
        ObjectAnimator animator1 = ObjectAnimator.ofFloat(mTextViewAddNewAccount, "scaleX", 0.9f, 1.1f).setDuration
                (duration);
        ObjectAnimator animator2 = ObjectAnimator.ofFloat(mTextViewAddNewAccount, "scaleY", 0.9f, 1.1f).setDuration
                (duration);
        animator1.setRepeatCount(-1);
        animator1.setRepeatMode(ObjectAnimator.REVERSE);
        animator2.setRepeatCount(-1);
        animator2.setRepeatMode(ObjectAnimator.REVERSE);
        animator1.start();
        animator2.start();
    }

    private void stopAnimator() {
        mTextViewAddNewAccount.clearAnimation();
    }
}
