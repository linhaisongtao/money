package com.example.daisongsong.moneytree.modules.newaccount;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.daisongsong.moneytree.R;
import com.example.daisongsong.moneytree.entity.Account;
import com.example.daisongsong.moneytree.modules.BaseActivity;
import com.example.daisongsong.moneytree.modules.newaccount.AddAccountPresenter.IAddAccountView;

/**
 * Created by daisongsong on 2015/11/13.
 */
public class AddAccountActivity extends BaseActivity implements View.OnClickListener ,IAddAccountView{
    private EditText mEditTextMoney;
    private TextView mTextViewConfirm;

    private AddAccountPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_account);

        mEditTextMoney = (EditText) findViewById(R.id.mEditTextMoney);
        mTextViewConfirm = (TextView) findViewById(R.id.mTextViewConfirm);
        mTextViewConfirm.setOnClickListener(this);

        mPresenter = new AddAccountPresenter(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.mTextViewConfirm:{
                mPresenter.confirm(mEditTextMoney.getText().toString());
                break;
            }
        }
    }

    @Override
    public void showAddSuccessView() {
        setResult(RESULT_OK);
        finish();
    }

    @Override
    public void showErrorView() {

    }
}
