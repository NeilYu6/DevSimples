package com.prtek.devsimples;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import com.prtek.devsimples.io.ThreadExecutor;

/**
 * Created by jarly on 2018/11/23.
 */

public class MainActivity extends AppCompatActivity {
  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    final ThreadExecutor threadExecutor = ThreadExecutor.getInstance();
    threadExecutor.io().execute(mRunnable);
    threadExecutor.main().execute(mRunnable);
  }

  private Runnable mRunnable = () -> Log.d("jarly",Thread.currentThread().getName());

}
