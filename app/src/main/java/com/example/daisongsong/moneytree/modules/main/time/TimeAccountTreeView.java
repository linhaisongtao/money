package com.example.daisongsong.moneytree.modules.main.time;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;

import com.example.daisongsong.moneytree.R;
import com.example.daisongsong.moneytree.entity.Account;

import java.util.List;

/**
 * Created by daisongsong on 2015/11/13.
 */
public class TimeAccountTreeView extends FrameLayout implements ITimeTreeAccountView{
    private RecyclerView mRecyclerView;
    private TimeAccountTreeAdapter mAdapter;
    private TimeAccountTreePresenter mPresenter;

    public TimeAccountTreeView(Context context) {
        super(context);
    }

    public TimeAccountTreeView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TimeAccountTreeView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        LayoutInflater.from(getContext()).inflate(R.layout.view_time_account_tree, this, true);
        init();
    }

    private void init(){
        mRecyclerView = (RecyclerView) findViewById(R.id.mRecyclerView);
        mAdapter = new TimeAccountTreeAdapter();
        mPresenter = new TimeAccountTreePresenter(this);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setAdapter(mAdapter);

        requestFirstPage();
    }

    @Override
    public void showList(List<Account> accounts) {
        mAdapter.setAccounts(accounts);
        mAdapter.notifyDataSetChanged();
    }

    public void requestFirstPage() {
        mPresenter.requestFirstPage();
    }
}
