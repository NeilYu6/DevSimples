package com.prtek.devsimples.io;

import java.util.concurrent.Executor;

/**
 * Created by jarly on 2018/11/23.
 *
 * 线程管理
 */

public class ThreadExecutor {

  private Executor mainExecutor;

  private Executor mIoExecutor;

  public ThreadExecutor(Executor mainExecutor, Executor ioExecutor) {
    this.mainExecutor = mainExecutor;
    mIoExecutor = ioExecutor;
  }

  private ThreadExecutor() {
    this(new MainThreadExecutor(), new IoThreadExecutor());
  }

  public Executor main() {
    return mainExecutor;
  }

  public Executor io() {
    return mIoExecutor;
  }

  public static ThreadExecutor getInstance() {
    return InstanceHolder.mThreadExecutor;
  }

  public interface InstanceHolder {
    ThreadExecutor mThreadExecutor = new ThreadExecutor();
  }
}
