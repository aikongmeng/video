package com.example.toge.myapplication;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by toge on 15/12/18.
 */
class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.MyViewHolder> {
    private static final String TAG ="VideoAdapter" ;
    private MyViewHolder viewHolder;
    private List<VideoEntity> mData;
    private Context context;

    public VideoAdapter(Context context,List<VideoEntity> mData) {
        this.mData = mData;
        this.context = context ;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = View.inflate(context, R.layout.item, null);
        viewHolder = new MyViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {

        int pos = holder.getLayoutPosition();
        int p = holder.getAdapterPosition();
        int pp = holder.getOldPosition();
        Log.i(TAG, "onBindViewHolder: " + pos + "," + position + "," + p + "," + pp);
        holder.videoView.setVideoURI(Uri.parse(mData.get(pos).getUrl()));
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder  {
        @Bind(R.id.videoView)
        AVideoView videoView;

        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);

        }
    }
}