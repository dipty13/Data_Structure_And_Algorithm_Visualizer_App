package com.dnerd.dipty.data_structure_and_algorithm_visualizer_app;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class LisVisualizer extends AppCompatActivity {
    private int[] mCodePic;
    private int[] mVisualizerPic;
    private int index = 0;
    private int flag = 0;
    private Button mNextButton;
    private Button mBackButton;
    private ImageView mPlayButton;
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
        setContentView(R.layout.activity_lis__visualizer);

        mPlayButton = findViewById(R.id.iv_play_button);
        mNextButton = findViewById(R.id.lis_next_button);
        mBackButton = findViewById(R.id.lis_back_button);
        mCodeLayout = findViewById(R.id.lis_code_linear_layout);
        mVisualizerLayout = findViewById(R.id.lis_visualizer_linear_layout);
        LisResources lisResources = new LisResources();
        mCodePic = lisResources.getCode();
        mVisualizerPic = lisResources.getmVisualizerPic();

        if(index <= 0)
        {
            mBackButton.setEnabled(false);
        }
        if(index >= 110)
        {
            mNextButton.setEnabled(false);
        }

        mNextButton.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View view) {
                mBackButton.setEnabled(true);
                index++;
                if(index == 111) {
                    mNextButton.setEnabled(false);
                }
                if(index <= 111) {
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
