package com.example.android.recyclerviewexample;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

class TestAdapter extends RecyclerView.Adapter<TestAdapter.TestViewHolder> {

    private int count;
    
    private final ItemListClickListener itemListClickListener;

    TestAdapter(int count, ItemListClickListener itemListClickListener) {

        this.count = count;

        this.itemListClickListener = itemListClickListener;

    }

    @Override
    public TestViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        Context context = parent.getContext();

        int layoutIdForListItem = R.layout.list_item;

        LayoutInflater inflater = LayoutInflater.from(context);

        boolean shouldAttachToParentImmediately = false;

        View view = inflater.inflate(layoutIdForListItem, parent, shouldAttachToParentImmediately);

        return new TestViewHolder(view);

    }

    @Override
    public void onBindViewHolder(TestViewHolder holder, int position) {

        holder.bind(position);

    }

    @Override
    public int getItemCount() {

        return count;

    }

    class TestViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView textView;

        TestViewHolder(View itemView) {

            super(itemView);

            textView = itemView.findViewById(R.id.tv_item_display);

            itemView.setOnClickListener(this);

        }

        void bind(int position) {

            textView.setText(String.valueOf(position));

        }

        @Override
        public void onClick(View view) {

            itemListClickListener.onListItemClicked(getAdapterPosition());
            
        }

    }

    interface ItemListClickListener {

        void onListItemClicked(int position);

    }

}
