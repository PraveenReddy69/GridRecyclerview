package com.ip.gridrecyclerview;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FullTimerAdapter extends RecyclerView.Adapter<FullTimerAdapter.TimerVH> {

    List<TimerModel> timerModelsList;
    private Context mContext;
    int LIMIT = 10;
    boolean isClicked = false;
    FullTimerInterface timerInterface;

    public FullTimerAdapter(List<TimerModel> timerModelsList, Context mContext) {
        this.timerModelsList = timerModelsList;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public TimerVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.custom_timer, parent, false);
        return new TimerVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TimerVH holder, int position) {
        TimerModel timerModel = timerModelsList.get(position);


        holder.tv_timer.setText(timerModel.time);


    }

    @Override
    public int getItemCount() {

        return timerModelsList.size();
    }

    class TimerVH extends RecyclerView.ViewHolder {

        private CardView cv_timer;
        private TextView tv_timer;

        public TimerVH(@NonNull View itemView) {
            super(itemView);
            cv_timer = itemView.findViewById(R.id.cv_timer);
            tv_timer = itemView.findViewById(R.id.tv_timer);
        }
    }


    
}


