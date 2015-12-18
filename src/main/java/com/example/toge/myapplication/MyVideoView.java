package com.example.toge.myapplication;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.VideoView;

/**
 * Created by toge on 15/12/16.
 */
public class MyVideoView extends VideoView {

    private static final String TAG = "MyVideoView";
    Context context;
    private boolean autoPlay;

    public MyVideoView(Context context) {
        super(context);
        this.context = context;
    }

    public MyVideoView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
    }

    public MyVideoView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        float sw = Constants.getScreenWidth(context) /1.5f  ;
        setMeasuredDimension((int)sw,  (int)((sw*9)/19f));
        Log.i(TAG, "onMeasure: w&h:"+getMeasuredWidth()+","+getMeasuredHeight());
    }

    public boolean isAutoPlay() {
        return autoPlay;
    }

    public void setAutoPlay(boolean autoPlay) {
        this.autoPlay = autoPlay;
    }

}
