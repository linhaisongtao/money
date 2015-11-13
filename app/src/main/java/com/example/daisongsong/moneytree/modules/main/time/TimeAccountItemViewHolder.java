package com.example.daisongsong.moneytree.modules.main.time;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.daisongsong.moneytree.R;
import com.example.daisongsong.moneytree.entity.Account;

/**
 * Created by daisongsong on 2015/11/13.
 */
public class TimeAccountItemViewHolder extends RecyclerView.ViewHolder {
    private TextView mTextViewContent;

    public TimeAccountItemViewHolder(ViewGroup parent) {
        super(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_time_account_view, parent, false));
        mTextViewContent = (TextView) itemView.findViewById(R.id.mTextViewContent);
    }

    public void bindAccount(Account account, int position, int itemCount) {
        mTextViewContent.setText(String.format("%.2f", account.getMoneyInYuanDouble()));
    }
}
