package com.example.toge.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    @Bind(R.id.recyclerView)
    RecyclerView recyclerViewVideo;
    @Bind(R.id.recyclerView_text)
    RecyclerView recyclerViewText;
    private VideoAdapter videoAdapter;
    private TextAdapter textAdapter;//文本适配器
    private List<VideoEntity> videoData;//视频集合
    private List<TextEntity> textData;//文本集合
    private int screenWidth;//屏幕宽度
    private int spacingInPixels;//间隔


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        init();
        video();
        text();
    }

    private void init() {
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        screenWidth = metrics.widthPixels;
        spacingInPixels = getResources().getDimensionPixelSize(R.dimen.space);
    }

    private void text() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerViewText.setLayoutManager(layoutManager);
        recyclerViewText.addItemDecoration(new SpaceItemDecoration(spacingInPixels));
        textAdapter = new TextAdapter(this, initTextData());
        recyclerViewText.setAdapter(textAdapter);
    }


    private void video() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerViewVideo.setLayoutManager(layoutManager);
        videoAdapter = new VideoAdapter(this, initData());
        recyclerViewVideo.setAdapter(videoAdapter);
    }

    private List<TextEntity> initTextData() {
        textData = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            TextEntity bean = new TextEntity();
            bean.setText(Constants.strings[i]);
            textData.add(bean);
        }
        return textData;
    }

    private List<VideoEntity> initData() {

        videoData = new ArrayList<>();
        for (int i = 0; i < Constants.urls.length; i++) {
            VideoEntity bean = new VideoEntity();
            bean.setImgUrl(null);
            bean.setUrl(Constants.urls[i]);
            videoData.add(bean);

        }
        return videoData;
    }

}
