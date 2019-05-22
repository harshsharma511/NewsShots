package com.example.newsshots;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        getSupportActionBar().hide();
    }
    @OnClick(R.id.btn1)
    public void indianNews(View view){
        Intent intent=new Intent(MainActivity.this,IndianNewsActivity.class);
        startActivity(intent);
    }

}
