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

public class TimerAdapter extends RecyclerView.Adapter<TimerAdapter.TimerVH> {

    List<TimerModel> timerModelsList;
    private Context mContext;
    int LIMIT = 10;
    boolean isClicked = false;
    FullTimerInterface timerInterface;

    public TimerAdapter(List<TimerModel> timerModelsList, Context mContext) {
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

        if (position == 9) {
            String more_size = String.valueOf(timerModelsList.size() - 9);


            holder.tv_timer.setText("+" + more_size);
            holder.cv_timer.setCardBackgroundColor(Color.parseColor("#A120B7FA"));


            holder.cv_timer.setOnClickListener(v -> {

                isClicked = true;
                Toast.makeText(mContext, "Reddy", Toast.LENGTH_SHORT).show();
                timerInterface.showddialog();

            });
        } else {
            holder.tv_timer.setText(timerModel.time);
            holder.cv_timer.setOnClickListener(v -> {
                Toast.makeText(mContext, "LESS", Toast.LENGTH_SHORT).show();
            });
        }

    }

    @Override
    public int getItemCount() {
        if (timerModelsList.size() >= LIMIT) {
            return LIMIT;
        }
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


    public void initlizefultimer(FullTimerInterface fullTimerInterface) {
        this.timerInterface = fullTimerInterface;

    }
}


