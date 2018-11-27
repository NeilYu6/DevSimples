package com.prtek.devsimples.util;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;

/**
 * 倒计时
 *
 * Created by jarly on 2018/11/23.
 *
 */
public abstract class Countdown implements Runnable {

  private static final int HZ = 500;

  private final int mSeconds;

  private final Handler mHandler;

  private long mStartTime;

  private int mCountdown;

  public Countdown(int seconds) {
    mSeconds = seconds;
    final Looper looper = Looper.myLooper();
    if (looper != null) {
      mHandler = new Handler(looper);
    } else {
      mHandler = new Handler(Looper.getMainLooper());
    }
  }

  public void start() {
    mStartTime = SystemClock.uptimeMillis();
    mHandler.removeCallbacks(this);
    mHandler.postDelayed(this, HZ);
    mCountdown = mSeconds;
    onTick(mSeconds);
  }

  public void stop() {
    mHandler.removeCallbacks(this);
  }

  @Override public void run() {
    final long now = SystemClock.uptimeMillis();
    final int countdown = mSeconds - (int) ((now - mStartTime) / 1000);
    if (countdown <= 0) {
      onTick(0);
    } else {
      mHandler.postDelayed(this, HZ);
      if (countdown != mCountdown) {
        mCountdown = countdown;
        onTick(countdown);
      }
    }
  }

  protected abstract void onTick(int tick);
}
