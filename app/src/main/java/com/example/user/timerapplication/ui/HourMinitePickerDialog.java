package com.example.user.timerapplication.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v4.view.LayoutInflaterCompat;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.NumberPicker;

import com.example.user.timerapplication.R;

/**
 * Created by user on 16/04/03.
 */
public class HourMinitePickerDialog {

    final private Activity activity;

    public HourMinitePickerDialog(Activity activity){
        this.activity = activity;
    }

    public void build(){
        final View v = getCustomView();
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setTitle(R.string.dialog_setting);
        builder.setView(v);
        initNumberPickers(v);

        builder.setPositiveButton(R.string.dialog_ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        builder.show();

    }

    private View getCustomView(){
        final LayoutInflater inflater
                = (LayoutInflater) LayoutInflater.from(activity);
        View v = inflater.inflate(R.layout.timer_setting,
                (ViewGroup)activity.findViewById(R.id.timerSetting));
        return v;

    }

    private void initNumberPickers(View v){
        final NumberPicker picker1 = (NumberPicker) v.findViewById(R.id.numberPicker);
        final NumberPicker picker2 = (NumberPicker) v.findViewById(R.id.numberPicker2);
        final NumberPicker picker3 = (NumberPicker) v.findViewById(R.id.numberPicker3);
        final NumberPicker picker4 = (NumberPicker) v.findViewById(R.id.numberPicker4);

        picker1.setMaxValue(9);
        picker1.setMinValue(0);
        picker2.setMaxValue(9);
        picker2.setMinValue(0);
        picker3.setMaxValue(5);
        picker3.setMinValue(0);
        picker4.setMaxValue(5);
        picker4.setMinValue(0);

    }
}
