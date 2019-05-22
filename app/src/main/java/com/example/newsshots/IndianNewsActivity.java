package com.example.newsshots;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.newsshots.api.MyRetro;
import com.example.newsshots.model.Article;
import com.example.newsshots.model.NewsPojoRes;

import java.util.List;

import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class IndianNewsActivity extends AppCompatActivity {
    //    @BindView(R.id.txt)
//    TextView Mytext;
    List<Article> articles = null;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_indian_news);
        getSupportActionBar().hide();
        getAllUSersData();
        recyclerView=findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ButterKnife.bind(this);
    }

    private void getAllUSersData() {
//        Map<String, String> params = new HashMap<>();
//        params.put("country","in");
//        params.put("apiKey","2d37575ab78c42f09ea6bc38c6dc755f");
        MyRetro.api.getIndianNews().enqueue(new Callback<NewsPojoRes>() {
            @Override
            public void onResponse(Call<NewsPojoRes> call, Response<NewsPojoRes> response) {
                NewsPojoRes res = response.body();
                if (res.getStatus().equals("ok")) {
                    articles = res.getArticles();
                   // List<NewsPojoRes> list = response.body();
                    NewsRecyclerAdapter adapter = new NewsRecyclerAdapter(IndianNewsActivity.this,articles);
                    recyclerView.setAdapter(adapter);
                } else {
                    Toast.makeText(IndianNewsActivity.this, "Not Ok", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<NewsPojoRes> call, Throwable t) {

            }
        });

    }
}
