package com.example.recycler_demo2;

import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Modals> list;
    RecyclerView rv;
    PaginationAdapter pag_Adapter;
    private boolean isScrolling = false;
    LinearLayoutManager layoutManager;
    ProgressBar progressBar;

    private static final String TAG = "MainActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = findViewById(R.id.progress);
        layoutManager = new LinearLayoutManager(this);
        rv=findViewById(R.id.recyclerView);
        rv.setLayoutManager(layoutManager);
        list = new ArrayList<>();



        pag_Adapter = new PaginationAdapter(list);
        rv.setAdapter(pag_Adapter);
        rv.setHasFixedSize(true);

        rv.addOnScrollListener(recyclerViewPagination);

        putData();
    }

    private void putData() {
        Modals model;
        for(int i=0; i<5; i++){
            model = new Modals();
            model.setFood_Name("Ice Cream Sundae");
            model.setAddress("145, Mall of India");
            model.setReviews("520 Reviews");
            model.setPrice("Rs. 180");
            model.setRating(3.50f);
            model.setDate(new SimpleDateFormat("dd MMMM yyyy hh:mm:ss").format(new Date()));
            model.setImage(R.drawable.pic1);
            list.add(model);
        }
    }


    private RecyclerView.OnScrollListener recyclerViewPagination = new RecyclerView.OnScrollListener() {
        @Override
        public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
            super.onScrollStateChanged(recyclerView, newState);

            if (newState == AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL) {
                isScrolling = true;
            }
        }

        @Override
        public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);
            int totalItems = layoutManager.getItemCount();
            int visibleItems = layoutManager.getChildCount();
            int scrolledOutItems = layoutManager.findFirstVisibleItemPosition();
            if (isScrolling && visibleItems + scrolledOutItems == totalItems) {
                isScrolling = false;
                fetchData();
            }
        }
    };

    private void fetchData() {
        progressBar.setVisibility(View.VISIBLE);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                for(int i=0; i<=5; i++){
                  Modals  m1 = new Modals();
                    m1.setFood_Name("Ice Cream Sundae");
                    m1.setAddress("145, Mall of India");
                    m1.setReviews("520 Reviews");
                    m1.setDate(new SimpleDateFormat("dd MMMM yyyy hh:mm:ss").format(new Date()));
                    m1.setPrice("Rs. 180");
                    m1.setRating(3.50f);
                    m1.setImage(R.drawable.pic1);
                    list.add(m1);

                    pag_Adapter.notifyDataSetChanged();
                    progressBar.setVisibility(View.GONE);
                }

            }
        },2000);

    }
}
