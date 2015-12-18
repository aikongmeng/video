package com.example.toge.myapplication;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

/**
 * Created by toge on 15/12/18.
 * 文本适配器
 */
class TextAdapter extends RecyclerView.Adapter<TextAdapter.MyViewHolder> {

    private final Context context;
    private MyViewHolder viewHolder;
    private List<TextEntity> mData;

    public TextAdapter(Context context,List<TextEntity> mData) {
        this.mData = mData;
        this.context = context;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.item_text, null);
        viewHolder = new MyViewHolder(view);


        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {

        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showEidt(holder);

            }
        });


        holder.editText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    showEidt(holder);
                }else {
                    goneEidt(holder);
                }

            }
        });
    }

    private void showEidt( MyViewHolder holder){
        holder.textView.setVisibility(View.GONE);
        holder.editText.setVisibility(View.VISIBLE);
        holder.editText.selectAll();
    }

    private void goneEidt( MyViewHolder holder){
        holder.textView.setVisibility(View.VISIBLE);
        holder.editText.setVisibility(View.GONE);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView textView;
        EditText editText;
        public MyViewHolder(View itemView) {
            super(itemView);
            editText = (EditText) itemView.findViewById(R.id.editText);
            textView = (TextView) itemView.findViewById(R.id.textView);
        }


    }


}