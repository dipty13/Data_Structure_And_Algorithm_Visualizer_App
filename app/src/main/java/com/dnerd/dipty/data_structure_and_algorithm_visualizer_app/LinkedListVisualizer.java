package com.dnerd.dipty.data_structure_and_algorithm_visualizer_app;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import static java.lang.Thread.sleep;

public class LinkedListVisualizer extends AppCompatActivity {
    private int[] mCodePic;
    private int[] mVisualizerPic;
    private int index = 0;
    private int flag = 0;
    private ImageView mPlayButton;
    private Button mNextButton;
    private Button mBackButton;
    private LinearLayout mCodeLayout;
    private LinearLayout mVisualizerLayout;
    private boolean mRun = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }

        setContentView(R.layout.activity_linked_list_visualizer);

        mPlayButton = findViewById(R.id.iv_play_button);
        mNextButton = findViewById(R.id.linked_list_next_button);
        mBackButton = findViewById(R.id.linked_list_back_button);
        mCodeLayout = findViewById(R.id.linked_list_code_linear_layout);
        mVisualizerLayout = findViewById(R.id.linked_list_visualizer_linear_layout);
        LinkedListResources linkedListResources = new LinkedListResources();
        mCodePic = linkedListResources.getmCodePic();
        mVisualizerPic = linkedListResources.getmVisualizerPic();

        if (index <= 0) {
            mBackButton.setEnabled(false);
        }
        if (index >= 48) {
            mNextButton.setEnabled(false);
        }

        mNextButton.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View view) {
                mBackButton.setEnabled(true);
                mRun = false;
                index++;
                if (index == 48) {
                    mNextButton.setEnabled(false);
                }
                if (index <= 48) {
                    mCodeLayout.setBackground(getResources().getDrawable(mCodePic[index]));
                    mVisualizerLayout.setBackground(getResources().getDrawable(mVisualizerPic[index]));
                } else {
                    mNextButton.setEnabled(false);
                }

            }
        });
        mBackButton.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View view) {
                mNextButton.setEnabled(true);
                mRun = false;
                index--;
                if (index == 0) {
                    mBackButton.setEnabled(false);
                }
                if (index >= 0) {
                    mCodeLayout.setBackground(getResources().getDrawable(mCodePic[index]));
                    mVisualizerLayout.setBackground(getResources().getDrawable(mVisualizerPic[index]));
                } else {
                    mBackButton.setEnabled(false);

                }
            }
        });

        /*final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mVisualizerLayout.setBackground(getResources()
                        .getDrawable(mVisualizerPic[index]));
                index++;
                if (index > mVisualizerPic.length - 1) {
                    index = 0;
                }
            }
        }, 2000);*/

        mPlayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!mRun) {
                    mPlayButton.setImageResource(R.drawable.ic_pause);
                    startShow();
                    runThread();

                } else {
                    stopShow();
                    mPlayButton.setImageResource(R.drawable.ic_play);
                    runThread();
                }
            }
        });

    }

    private void runThread() {
        final Handler handler = new Handler();
        final Runnable runnable = new Runnable() {
            @Override
            public void run() {
                while(mRun){
                    mVisualizerLayout.setBackgroundResource(mVisualizerPic[index]);
                    mCodeLayout.setBackgroundResource(mCodePic[index]);
                    index++;
                    if(index > 0){
                        mBackButton.setEnabled(true);
                    }
                    if (index > mVisualizerPic.length - 1) {
                        mNextButton.setEnabled(false);
                        mPlayButton.setImageResource(R.drawable.ic_play);
                        mRun = false;
                        index = 0;
                    }
                   handler.postDelayed(this, 1000);
                }
            }
        };
        handler.postDelayed(runnable, 1000);
    }

    public void startShow(){
        mRun = true;
    }

    public void stopShow() {
        mRun = false;
    }
}
