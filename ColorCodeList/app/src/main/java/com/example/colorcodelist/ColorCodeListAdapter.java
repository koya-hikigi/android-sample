package com.example.colorcodelist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class ColorCodeListAdapter extends ArrayAdapter<ColorCodeItem> {

    private LayoutInflater mLayoutInflater;
    private List<ColorCodeItem> mDataList;

    public ColorCodeListAdapter(@NonNull Context context,  @NonNull List<ColorCodeItem> dataList) {
        super(context, R.layout.layout_list_item, dataList);
        mLayoutInflater = LayoutInflater.from(context);
        mDataList = dataList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        ListItemHolder holder;
        if(convertView == null){
            convertView = mLayoutInflater.inflate(R.layout.layout_list_item, parent, false);
            holder = new ListItemHolder();
            ImageView imageView = convertView.findViewById(R.id.color_image);
            TextView textView = convertView.findViewById(R.id.color_code_text);
            holder.setColorImageView(imageView);
            holder.setColorCodeTextView(textView);
            convertView.setTag(holder);

        } else {
            holder = (ListItemHolder) convertView.getTag();

        }
        ColorCodeItem item = mDataList.get(position);
        // 色を設定
        holder.getColorImageView().setBackgroundResource(item.getId());
        // タイトルを設定する箇所
        holder.getColorCodeTextView().setText(item.getTitle());

        return convertView;
    }

    @Nullable
    @Override
    public ColorCodeItem getItem(int position) {
        return mDataList.get(position);
    }


    @Override
    public int getCount() {
        return mDataList.size();
    }

    private class ListItemHolder{

        private ImageView colorImageView;
        private TextView colorCodeTextView;

        ImageView getColorImageView() {
            return colorImageView;
        }

        void setColorImageView(ImageView colorImageView) {
            this.colorImageView = colorImageView;
        }

        TextView getColorCodeTextView() {
            return colorCodeTextView;
        }

        void setColorCodeTextView(TextView colorCodeTextView) {
            this.colorCodeTextView = colorCodeTextView;
        }

    }

}
