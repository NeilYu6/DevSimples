package com.prtek.devsimples.io;

import android.support.annotation.NonNull;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by jarly on 2018/11/23.
 */

public class IoThreadExecutor implements Executor {
  private  Executor mExecutor;

  public IoThreadExecutor() {
    ThreadFactory namedThreadFactory = new ThreadFactoryBuilder()
        .setNameFormat("pool-%d")
        .build();
    mExecutor = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS,
        new LinkedBlockingQueue<Runnable>(1024), namedThreadFactory,
        new ThreadPoolExecutor.AbortPolicy());
  }

  @Override public void execute(@NonNull Runnable runnable) {
    mExecutor.execute(runnable);
  }
}
