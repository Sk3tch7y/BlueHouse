package com.bluehouse.bluehouse;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewAdapterVertical extends RecyclerView.Adapter<RecyclerViewAdapterVertical.ViewHolder> {




    private ArrayList<Notification> mainNotificationList = new ArrayList<>();
    public OnNotificationListener monNotificationListener;
    private Context mContext;

    public RecyclerViewAdapterVertical(Context mContext, ArrayList<Notification> list, OnNotificationListener onNotificationListener) {
        this.mainNotificationList = list;
        this.mContext = mContext;
        this.monNotificationListener = onNotificationListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_notification_item, parent, false);
        return new ViewHolder(view, monNotificationListener);
    }
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.notificationName.setText(mainNotificationList.get(position).getName());
        holder.notificationContent.setText(mainNotificationList.get(position).getContent());
    }
    @Override
    public int getItemCount() {
        return mainNotificationList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    TextView notificationName, notificationContent;
    OnNotificationListener onNotificationListener;

    public ViewHolder(View itemView, OnNotificationListener onNotificationListener) {
        super(itemView);
        notificationName = itemView.findViewById(R.id.notificationCard_notification_name);
        notificationContent = itemView.findViewById(R.id.notificationCard_notification_content);

        this.onNotificationListener = onNotificationListener;

        itemView.setOnClickListener(this);
    }

        @Override
        public void onClick(View v) {
            onNotificationListener.onNotificationClick(getAdapterPosition());
        }
    }
public interface OnNotificationListener{
        void onNotificationClick(int position);
}




}
