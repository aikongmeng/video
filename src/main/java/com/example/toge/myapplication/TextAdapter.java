package com.example.toge.myapplication;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by toge on 15/12/18.
 * 文本适配器
 */
class TextAdapter extends RecyclerView.Adapter<TextAdapter.MyViewHolder> {

    private static final String TAG = "TextAdapter";
    private final Context context;
    private MyViewHolder viewHolder;
    private List<TextEntity> mData;
    private int index;

    public TextAdapter(Context context, List<TextEntity> mData) {
        this.mData = mData;
        this.context = context;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_text, parent, false);
        viewHolder = new MyViewHolder(view, new MyCustomEditTextListener());


        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {

        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                index = position;
                showEidt(holder);
//                holder.editText.setText(mData.get(position).getText()+"");

            }
        });


        holder.myCustomEditTextListener.updatePosition(position);
        holder.editText.setText(mData.get(position).getText());


//        holder.editText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
//            @Override
//            public void onFocusChange(View v, boolean hasFocus) {
//                Log.i(TAG, "onFocusChange: hasFocus:"+ hasFocus);
//                if (hasFocus) {
//                    showEidt(holder);
//                } else {
//                    goneEidt(holder);
//                }
//
//            }
//        });
    }


    private void showEidt(MyViewHolder holder) {
        holder.textView.setVisibility(View.GONE);
        holder.editText.setVisibility(View.VISIBLE);
        holder.editText.selectAll();
    }

    private void goneEidt(MyViewHolder holder) {
        holder.textView.setVisibility(View.VISIBLE);
        holder.editText.setVisibility(View.GONE);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {


        @Bind(R.id.textView)
        TextView textView;
        @Bind(R.id.editText)
        EditText editText;
        public MyCustomEditTextListener myCustomEditTextListener;

        public MyViewHolder(View itemView, MyCustomEditTextListener l) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            myCustomEditTextListener = l;
            editText.addTextChangedListener(myCustomEditTextListener);
        }

    }


     class MyCustomEditTextListener implements TextWatcher {
        private int position;

        public void updatePosition(int position) {
            this.position = position;
        }

        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            // no op
        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            mData.get(position).setText(charSequence.toString());
        }

        @Override
        public void afterTextChanged(Editable editable) {
            // no op
        }
    }


}