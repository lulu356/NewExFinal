package com.example.newex.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.newex.HotelDB.Message;
import com.example.newex.R;

import java.util.List;

public class MessAdapterlist extends RecyclerView.Adapter<MessAdapterlist.ViewHolder> {
private static final int CHAT_END = 1;
private static final int CHAT_START = 2;

private List<Message> mDataSet;
private String mId;

        /**
         * Called when a view has been clicked.
         *
         * @param dataSet Message list
         * @param id      Device id
         */
        public MessAdapterlist(List<Message> dataSet, String id) {
        mDataSet = dataSet;
        mId = id;
        }

@Override
public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v;

        if (viewType == CHAT_END) {
        v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_chat_end, parent, false);
        } else {
        v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_chat_start, parent, false);
        }

        return new ViewHolder(v);
        }

@Override
public int getItemViewType(int position) {
        if (mDataSet.get(position).getId().equals(mId)) {
        return CHAT_END;
        }

        return CHAT_START;
        }

@Override
public void onBindViewHolder(ViewHolder holder, int position) {
        Message chat = mDataSet.get(position);
        holder.mTextView.setText(chat.getMessage());
        }

@Override
public int getItemCount() {
        return mDataSet.size();
        }

/**
 * Inner Class for a recycler view
 */
class ViewHolder extends RecyclerView.ViewHolder {
    TextView mTextView;

    ViewHolder(View v) {
        super(v);
        mTextView = (TextView) itemView.findViewById(R.id.tvMessage);
    }
}
}
