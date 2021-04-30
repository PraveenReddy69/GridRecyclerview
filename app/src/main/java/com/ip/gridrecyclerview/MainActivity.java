package com.ip.gridrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements FullTimerInterface {

    private Context mContext = this;
    List<TimerModel> timerModels = new ArrayList<>();
    TimerAdapter timerAdapter;
    FullTimerAdapter fullTimerAdapter;
    RecyclerView rc_timer;
    GridLayoutManager gridLayoutManager;
    GridLayoutManager gridLayoutManager_full_timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rc_timer = findViewById(R.id.rc_timer);
        gridLayoutManager = new GridLayoutManager(mContext, 5, RecyclerView.VERTICAL, false);
        rc_timer.setLayoutManager(gridLayoutManager);

        timerModels.add(new TimerModel("09:00"));
        timerModels.add(new TimerModel("08:30"));
        timerModels.add(new TimerModel("09:00"));

        timerModels.add(new TimerModel("05:00"));
        timerModels.add(new TimerModel("09:40"));
        timerModels.add(new TimerModel("09:00"));

        timerModels.add(new TimerModel("09:50"));
        timerModels.add(new TimerModel("03:00"));
        timerModels.add(new TimerModel("09:50"));

        timerModels.add(new TimerModel("09:00"));
        timerModels.add(new TimerModel("01:00"));
        timerModels.add(new TimerModel("09:00"));


        timerModels.add(new TimerModel("09:50"));
        timerModels.add(new TimerModel("03:00"));
        timerModels.add(new TimerModel("09:50"));

        timerModels.add(new TimerModel("09:00"));
        timerModels.add(new TimerModel("01:00"));
        timerModels.add(new TimerModel("09:00"));

        timerModels.add(new TimerModel("02:00"));

        timerAdapter = new TimerAdapter(timerModels, mContext);
        timerAdapter.initlizefultimer(this);
        rc_timer.setAdapter(timerAdapter);


    }

    @Override
    public void showddialog() {
        View view = getLayoutInflater().inflate(R.layout.custom_dialog_full_timer, null);
        Dialog dialog = new Dialog(mContext);
        dialog.setContentView(view);
        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        lp.copyFrom(dialog.getWindow().getAttributes());
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;


        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);

        RecyclerView rc_full_timer = view.findViewById(R.id.rc_dialog_full_timer);
        gridLayoutManager_full_timer = new GridLayoutManager(mContext, 5, RecyclerView.VERTICAL, false);
        rc_full_timer.setLayoutManager(gridLayoutManager_full_timer);
        fullTimerAdapter=new FullTimerAdapter(timerModels,mContext);
        rc_full_timer.setAdapter(fullTimerAdapter);

        dialog.show();
        dialog.getWindow().setAttributes(lp);
    }
}