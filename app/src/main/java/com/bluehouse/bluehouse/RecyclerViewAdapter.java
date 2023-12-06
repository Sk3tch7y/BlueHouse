package com.bluehouse.bluehouse;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {



//possibly create and entirely new greenhouse class and pass into these arrays so that you don't actually have to use 5 different ones

    private ArrayList<GreenhouseData> greenhouseList = new ArrayList<>();


    public OnGreenHouseListener monGreenHouseListener;

    private Context mContext;

    public RecyclerViewAdapter(Context mContext, ArrayList<GreenhouseData> list, OnGreenHouseListener onGreenHouseListener) {
        this.greenhouseList = list;
        this.mContext = mContext;
        this.monGreenHouseListener = onGreenHouseListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_greenhouse_item, parent, false);
        return new ViewHolder(view, monGreenHouseListener);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.greenHouseName.setText(greenhouseList.get(position).getName());
        holder.temp.setText(greenhouseList.get(position).getCurrentTemp());
        holder.humidity.setText(greenhouseList.get(position).getCurrentHumidity());
        holder.light.setText(greenhouseList.get(position).getCurrentLight());
        holder.otherInfo.setText(greenhouseList.get(position).getCurrentOther());
    }



    @Override
    public int getItemCount() {
        return greenhouseList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    TextView greenHouseName, temp, humidity, light, otherInfo;
    OnGreenHouseListener onGreenHouseListener;

    public ViewHolder(View itemView, OnGreenHouseListener onGreenHouseListener) {
        super(itemView);
        greenHouseName = itemView.findViewById(R.id.homecard_greenhouse_name);
        temp = itemView.findViewById(R.id.homecard_greenhouse_temp);
        humidity = itemView.findViewById(R.id.homecard_greenhouse_humidity);
        light = itemView.findViewById(R.id.homecard_greenhouse_light);
        otherInfo = itemView.findViewById(R.id.homecard_greenhouse_other);
        this.onGreenHouseListener = onGreenHouseListener;

        itemView.setOnClickListener(this);
    }

        @Override
        public void onClick(View v) {
            onGreenHouseListener.onGreenHouseClick(getAdapterPosition());
        }
    }


public interface OnGreenHouseListener{
        void onGreenHouseClick(int position);



}




}
