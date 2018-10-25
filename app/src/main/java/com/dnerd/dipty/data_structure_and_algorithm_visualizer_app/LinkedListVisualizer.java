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
            R.drawable.code1,
            R.drawable.code2,
            R.drawable.code3,
            R.drawable.code4,
            R.drawable.code5,
            R.drawable.code6,
            R.drawable.code7,
            R.drawable.code8,
            R.drawable.code9,
            R.drawable.code10,
            R.drawable.code11,
    };
    private int index = -1;
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
        if(index >= 10)
        {
            mBackButton.setEnabled(false);
        }
        
            mNextButton.setOnClickListener(new View.OnClickListener() {
                @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
                @Override
                public void onClick(View view) {
                    mBackButton.setEnabled(true);
                    index++;
                    if(index <= 10) {
                        mCodeLayout.setBackground(getResources().getDrawable(mCodePic[index]));
                    }else{
                        mNextButton.setEnabled(false);
                       // mBackButton.setEnabled(true);
                    }

                }
            });
        mBackButton.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View view) {
                mNextButton.setEnabled(true);
                index--;
                if(index >= 0) {
                    mCodeLayout.setBackground(getResources().getDrawable(mCodePic[index]));
                }else {
                    mBackButton.setEnabled(false);

                }
            }
        });

    }
}
