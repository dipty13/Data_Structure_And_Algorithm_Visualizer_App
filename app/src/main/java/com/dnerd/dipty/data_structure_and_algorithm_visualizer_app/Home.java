package com.dnerd.dipty.data_structure_and_algorithm_visualizer_app;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Window;
import android.view.WindowManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Home extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;

    private List<HomeList> mListItems;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT)
        {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
        setContentView(R.layout.activity_home);

        mRecyclerView = findViewById(R.id.home_activity_recycler_view);

        mRecyclerView.setHasFixedSize(true);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mListItems = new ArrayList<>();
        HomeList listItem1 = new HomeList(
                "Linked List",
                ""
        );
        HomeList listItem2 = new HomeList(
                "Linked List",
                ""
        );
        HomeList listItem3 = new HomeList(
                "Linked List",
                ""
        );
        HomeList listItem4 = new HomeList(
                "Linked List",
                ""
        );
        HomeList listItem5 = new HomeList(
                "Linked List",
                ""
        );
        HomeList listItem6 = new HomeList(
                "Linked List",
                ""
        );
        HomeList listItem7 = new HomeList(
                "Linked List",
                ""
        );
        HomeList listItem8 = new HomeList(
                "Linked List",
                ""
        );
        HomeList listItem9 = new HomeList(
                "Linked List",
                ""
        );
        HomeList listItem10 = new HomeList(
                "Linked List",
                ""
        );
        HomeList listItem11 = new HomeList(
                "Linked List",
                ""
        );


        mListItems.add(listItem1);
        mListItems.add(listItem2);
        mListItems.add(listItem3);
        mListItems.add(listItem4);
        mListItems.add(listItem5);
        mListItems.add(listItem6);
        mListItems.add(listItem7);
        mListItems.add(listItem8);
        mListItems.add(listItem9);
        mListItems.add(listItem10);
        mListItems.add(listItem11);
        mAdapter = new HomeListAdapter(mListItems,this);
        mRecyclerView.setAdapter(mAdapter);
    }
}
