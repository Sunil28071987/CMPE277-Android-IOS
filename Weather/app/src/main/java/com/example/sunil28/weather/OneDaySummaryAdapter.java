package com.example.sunil28.weather;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by sunil28 on 10/24/17.
 */

public class OneDaySummaryAdapter extends  RecyclerView.Adapter<OneDaySummaryAdapter.HorizontalViewHolder>{

    private List<OneDaySummary> mOneDaySummary;

    private Context mContext;


    public OneDaySummaryAdapter(Context context, List<OneDaySummary> OneDaySummary) {
        mOneDaySummary = OneDaySummary;
        mContext = context;
    }

    // Easy access to the context object in the recyclerview
    private Context getContext() {
        return mContext;

    }

    @Override
    public OneDaySummaryAdapter.HorizontalViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View OneDaySummaryView = inflater.inflate(R.layout.item_layout,parent,false);
        HorizontalViewHolder viewHolder = new HorizontalViewHolder(OneDaySummaryView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(HorizontalViewHolder viewHolder, int position) {

        OneDaySummary oneDaySummary = mOneDaySummary.get(position);

        // Set item views based on your views and data model
        TextView hourTextView = viewHolder.hourTextView;
        hourTextView.setText(oneDaySummary.getTime());
        ImageView iconImageViewOneDay = viewHolder.iconImageViewOneDay;
        iconImageViewOneDay.setImageResource(oneDaySummary.getIcon());
        TextView tempTextView = viewHolder.tempTextView;
        tempTextView.setText(String.valueOf(oneDaySummary.getTemp()));

    }

    @Override
    public int getItemCount() {
        return mOneDaySummary.size();
    }

    public class HorizontalViewHolder extends RecyclerView.ViewHolder{
        TextView hourTextView;
        ImageView iconImageViewOneDay;
        TextView tempTextView;
        public HorizontalViewHolder(View itemView) {
            super(itemView);
            hourTextView = (TextView) itemView.findViewById(R.id.hourTextView);
            iconImageViewOneDay = (ImageView) itemView.findViewById(R.id.iconImageViewOneDay);
            tempTextView = (TextView) itemView.findViewById(R.id.tempTextView);

        }
    }

}
