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
    private int INDEX = 0;
    private int flag = 0;
    private FloatingActionButton mPlay;
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

        mPlay = findViewById(R.id.linked_list_play_floating_button);
        mCodeLayout = findViewById(R.id.linked_list_code_linear_layout);
        mVisualizerLayout = findViewById(R.id.linked_list_visualizer_linear_layout);

        
            mPlay.setOnClickListener(new View.OnClickListener() {
                @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
                @Override
                public void onClick(View view) {
                    if(flag == 0) {
                        mPlay.setBackground(getResources().getDrawable(R.drawable.ic_pause));
                        int i;
                        for( i = INDEX; i < mCodePic.length; i++) {

                            mCodeLayout.setBackground(getResources().getDrawable(mCodePic[INDEX]));

                        }
                        INDEX = i;
                        flag = 1;
                    }else{
                        mPlay.setBackground(getResources().getDrawable(R.drawable.ic_play));
                        flag = 0;
                    }
                }
            });

    }
}
