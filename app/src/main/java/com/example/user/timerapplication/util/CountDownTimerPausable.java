package com.example.user.timerapplication.util;

import android.os.CountDownTimer;
import android.util.Log;

/**
 * CountDownTimer extention to support Pause operation
 * Created by user on 16/04/03.
 */
public class CountDownTimerPausable {

    final private String TAG = CountDownTimerPausable.class.getSimpleName();

    private Listener listener = null;
    private CountDownTimer countDownTimer;
    private long remainingMils;
    private long countDownInterval;
    private boolean isRunning = false;

    public void init(long remainingMils, long countDownInterval){
        stop();

        this.remainingMils = remainingMils;
        this.countDownInterval = countDownInterval;
    }

    public synchronized void start() {
        if(isRunning) {
            return;
        }
        Log.v(TAG, "start");
        countDownTimer = new CountDownTimer(remainingMils, countDownInterval) {
            @Override
            public void onTick(long millisUntilFinished) {
                remainingMils = millisUntilFinished;
                if(listener != null) {
                    listener.CountDownTimerTick(millisUntilFinished);
                }
            }

            @Override
            public void onFinish() {
                if(listener != null) {
                    listener.CountDownTimerFinish();
                }
            }
        };
        countDownTimer.start();
        isRunning = true;
    }

    public void pause () {
        stop();
    }

    public synchronized void stop () {
        if(isRunning == false) {
            return;
        }
        countDownTimer.cancel();
        isRunning = false;
    }

    public void setListener (Listener listener){
        this.listener = listener;
    }

    public interface Listener {
        void CountDownTimerTick(long milsUntilFinished);
        void CountDownTimerFinish();
    }
}

