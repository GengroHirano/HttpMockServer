package com.example.self.edu.golangmockservier;

import android.database.Observable;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.example.self.edu.golangmockservier.databinding.ActivityMainBinding;

import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

  ActivityMainBinding mBinding;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

    mBinding.button.setOnClickListener(v -> {
      Subscription subscribe = new ServerMock().getApi()
              .getHello()
              .subscribeOn(Schedulers.newThread())
              .observeOn(AndroidSchedulers.mainThread())
              .subscribe(s -> {
                Toast.makeText(getApplicationContext(), "" + s, Toast.LENGTH_SHORT).show();
              }, throwable -> {
                throwable.printStackTrace();
              }, () -> {
                Log.v("Stream", "Complite");
              });
    });
  }
}
