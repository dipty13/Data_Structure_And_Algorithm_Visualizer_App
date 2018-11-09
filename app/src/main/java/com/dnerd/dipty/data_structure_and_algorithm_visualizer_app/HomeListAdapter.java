package com.dnerd.dipty.data_structure_and_algorithm_visualizer_app;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class HomeListAdapter extends RecyclerView.Adapter<HomeListAdapter.ViewHolderList> {
    private List<HomeList> mListItems;
    private Context mContext;
    public HomeListAdapter(List<HomeList> mListItems, Context mContext) {
        this.mListItems = mListItems;
        this.mContext = mContext;
    }
    @Override
    public ViewHolderList onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.home_list,parent,false);

        return new ViewHolderList(view);
    }
    @Override
    public void onBindViewHolder(HomeListAdapter.ViewHolderList holder, final int position) {
        final HomeList listItem = mListItems.get(position);

        holder.mTitleTextView.setText(listItem.getmTitle());
        holder.mSubtitleTextView.setText(listItem.getmSubTitle());
        final String item = listItem.getmTitle();

        holder.mHomeListLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext,"you clicked "+listItem.getmTitle(),Toast.LENGTH_LONG).show();
                if(item == "Linked List")
                {
                    Intent intent = new Intent(mContext, LinkedListVisualizer.class);
                    mContext.startActivity(intent);

                }
                if(item == "Longest Increasing Subsequence")
                {
                    Intent intent = new Intent(mContext, LisVisualizer.class);
                    mContext.startActivity(intent);

                }


            }
        });
    }

    @Override
    public int getItemCount() {
        return mListItems.size();
    }

    public class ViewHolderList extends RecyclerView.ViewHolder {
        public TextView mTitleTextView,mSubtitleTextView;
        public LinearLayout mHomeListLinearLayout;

        public ViewHolderList(View itemView) {
            super(itemView);

            mTitleTextView = itemView.findViewById(R.id.home_list_title_text_view);
            mSubtitleTextView = itemView.findViewById(R.id.home_list_subtitle_text_view);
            mHomeListLinearLayout = itemView.findViewById(R.id.home_list_linear_layout);
        }
    }
}
