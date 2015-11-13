package com.example.daisongsong.moneytree.modules.main.time;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.example.daisongsong.moneytree.entity.Account;

import java.util.List;

/**
 * Created by daisongsong on 2015/11/13.
 */
public class TimeAccountTreeAdapter extends RecyclerView.Adapter {
    private List<Account> mAccounts;

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new TimeAccountItemViewHolder(parent);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((TimeAccountItemViewHolder) holder).bindAccount(mAccounts.get(position), position, getItemCount());
    }

    @Override
    public int getItemCount() {
        return mAccounts == null ? 0 : mAccounts.size();
    }

    public void setAccounts(List<Account> accounts) {
        mAccounts = accounts;
    }
}
