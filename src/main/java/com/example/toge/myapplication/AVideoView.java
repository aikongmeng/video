package com.example.toge.myapplication;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

/**
 * Created by toge on 15/12/17.
 */
public class AVideoView extends FrameLayout {

    private static final String TAG = "AVideoView";
    private Context context;
    private MyVideoView videoView;
    private ImageView imageView_play;
    private ImageView imageView_replace;
    //    private ImageView imageView_stop;
    private boolean autoPlay;
    private ReplaceOnClickListener replaceOnClickListener;

    public AVideoView(Context context) {
        super(context);
        this.context = context;
        init();
    }

    public AVideoView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        init();
    }

    public AVideoView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        init();
    }

    private void init() {
        initView();
        pauseAndReplaceShow(false);
        setPlayAndReplace();
        setVideo();
    }

    private void setVideo() {

        videoView.setAutoPlay(true);

        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                stop();
            }
        });

        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                if (videoView.isAutoPlay()) {
                    play();
                } else {
                    pause();
                }

            }
        });
    }


    private void setPlayAndReplace() {
        imageView_play.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                play();
            }
        });

        imageView_replace.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (replaceOnClickListener != null) {
                    replaceOnClickListener.OnClick();
                }
            }
        });
    }

    private void play() {
        play(true);
        pauseAndReplaceShow(false);
    }

    private void pause() {
        play(false);
        pauseAndReplaceShow(true);
    }

    private void stop() {
        pauseAndReplaceShow(true);
    }

    private void initView() {

        LayoutInflater inflater = LayoutInflater.from(getContext());
        inflater.inflate(R.layout.videolayout, this, true);
//        addView(v);
        videoView = (MyVideoView) findViewById(R.id.myVideoView);
        imageView_play = (ImageView) findViewById(R.id.imageView1);
        imageView_replace = (ImageView) findViewById(R.id.imageView2);
//        imageView_stop = (ImageView) findViewById(R.id.imageView3);
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {

        Log.i(TAG, "onTouchEvent: " + event.getAction());
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            if (videoView != null) {

                if (videoView.isPlaying()) {
                    pause();
                    Log.i(TAG, "onTouchEvent: pause()");
                } else {
                    play();
                    Log.i(TAG, "onTouchEvent: play()");
                }
            }
        }
        return super.onTouchEvent(event);
    }


    private void play(boolean b) {
        if (videoView == null) return;
        if (b) {
            videoView.start();
        } else {
            videoView.pause();
        }
    }

    private void pauseAndReplaceShow(boolean show) {
        if (show) {
            imageView_play.setVisibility(VISIBLE);
            imageView_replace.setVisibility(VISIBLE);
        } else {
            imageView_play.setVisibility(GONE);
            imageView_replace.setVisibility(GONE);
        }
    }


    public void setReplaceOnClickListener(ReplaceOnClickListener replaceOnClickListener) {
        this.replaceOnClickListener = replaceOnClickListener;
    }


    public interface ReplaceOnClickListener {
        void OnClick();
    }


    public void setVideoURI(Uri uri) {
        videoView.setVideoURI(uri);
        videoView.requestFocus();
    }
}
