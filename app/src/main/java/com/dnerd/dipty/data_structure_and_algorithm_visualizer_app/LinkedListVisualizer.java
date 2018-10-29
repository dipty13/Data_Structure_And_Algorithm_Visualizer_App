package com.dnerd.dipty.data_structure_and_algorithm_visualizer_app;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;

public class LinkedListVisualizer extends AppCompatActivity {
    private int[] mCodePic = new int[]{
            R.drawable.code1, R.drawable.code2, R.drawable.code3,
            R.drawable.code4, R.drawable.code5, R.drawable.code6,
            R.drawable.code7,R.drawable.code8, R.drawable.code9,
            R.drawable.code10, R.drawable.code11, R.drawable.code12,
            R.drawable.code12i, R.drawable.code13, R.drawable.code14,
            R.drawable.code15, R.drawable.code16, R.drawable.code17,
            R.drawable.code18, R.drawable.code19, R.drawable.code20,
            R.drawable.code21, R.drawable.code22, R.drawable.code23,
            R.drawable.code24, R.drawable.code25, R.drawable.code26,
            R.drawable.code27, R.drawable.code28, R.drawable.code29,
            R.drawable.code30
    };
    private int[] mVisualizerPic = new int[]{
            R.drawable.linked_list1, R.drawable.linked_list2,
            R.drawable.linked_list3, R.drawable.linked_list4,
            R.drawable.linked_list5, R.drawable.linked_list6,
            R.drawable.linked_list7, R.drawable.linked_list8,
            R.drawable.linked_list9, R.drawable.linked_list10,
            R.drawable.linked_list11,R.drawable.linked_list12,
            R.drawable.linked_list12i, R.drawable.linked_list13,
            R.drawable.linked_list14, R.drawable.linked_list15,
            R.drawable.linked_list16, R.drawable.linked_list17,
            R.drawable.linked_list18, R.drawable.linked_list19,
            R.drawable.linked_list20, R.drawable.linked_list21,
            R.drawable.linked_list22, R.drawable.linked_list23,
            R.drawable.linked_list24, R.drawable.linked_list25,
            R.drawable.linked_list26, R.drawable.linked_list27,
            R.drawable.linked_list28, R.drawable.linked_list29,
            R.drawable.linked_list30
    };
    private int index = 0;
    private int flag = 0;
    private Button mPlayButton;
    private Button mNextButton;
    private Button mBackButton;
    private LinearLayout mCodeLayout;
    private LinearLayout mVisualizerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT)
        {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }

        setContentView(R.layout.activity_linked_list_visualizer);

        mPlayButton = findViewById(R.id.linked_list_play_button);
        mNextButton = findViewById(R.id.linked_list_next_button);
        mBackButton = findViewById(R.id.linked_list_back_button);
        mCodeLayout = findViewById(R.id.linked_list_code_linear_layout);
        mVisualizerLayout = findViewById(R.id.linked_list_visualizer_linear_layout);

        if(index <= 0)
        {
            mBackButton.setEnabled(false);
        }
        if(index >= 30)
        {
            mNextButton.setEnabled(false);
        }
        
            mNextButton.setOnClickListener(new View.OnClickListener() {
                @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
                @Override
                public void onClick(View view) {
                    mBackButton.setEnabled(true);
                    index++;
                    if(index == 30) {
                        mNextButton.setEnabled(false);
                    }
                    if(index <= 30) {
                        mCodeLayout.setBackground(getResources().getDrawable(mCodePic[index]));
                        mVisualizerLayout.setBackground(getResources().getDrawable(mVisualizerPic[index]));
                    }else{
                        mNextButton.setEnabled(false);
                    }

                }
            });
        mBackButton.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View view) {
                mNextButton.setEnabled(true);
                index--;
                if(index == 0) {
                    mBackButton.setEnabled(false);
                }
                if(index >= 0) {
                    mCodeLayout.setBackground(getResources().getDrawable(mCodePic[index]));
                    mVisualizerLayout.setBackground(getResources().getDrawable(mVisualizerPic[index]));
                }else {
                    mBackButton.setEnabled(false);

                }
            }
        });

    }
}
