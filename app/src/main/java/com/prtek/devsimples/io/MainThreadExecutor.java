package com.prtek.devsimples.io;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import java.util.concurrent.Executor;

/**
 * Created by jarly on 2018/11/23.
 */

public class MainThreadExecutor implements Executor {

  private Handler mHandler = new Handler(Looper.getMainLooper());

  @Override public void execute(@NonNull Runnable runnable) {
    mHandler.post(runnable);
  }
}
