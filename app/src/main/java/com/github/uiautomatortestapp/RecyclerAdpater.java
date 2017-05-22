package com.github.uiautomatortestapp;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.github.uiautomatortestapp.bean.Books;

/**
 * Created by xulin on 2017/5/22 0022.
 */

public class RecyclerAdpater extends RecyclerView.Adapter<RecyclerAdpater.MyHolder> {

    private Context mContext;
    private Books mBooks;
    public RecyclerAdpater(Context context) {
        mContext = context;
    }

    public void setData(Books books){
        mBooks = books;
        notifyDataSetChanged();
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View rootView = View.inflate(mContext,R.layout.card_item,null);
        return new MyHolder(rootView);
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
        final Books.BooksBean booksBean = mBooks.books.get(position);
        holder.mTitileView.setText(booksBean.title);
        holder.mDescView.setText(booksBean.describe);
        holder.mCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext,booksBean.title,Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mBooks==null?0:mBooks.books.size();
    }

    class MyHolder extends RecyclerView.ViewHolder{
        TextView mTitileView;
        TextView mDescView;
        CardView mCardView;
        public MyHolder(View itemView) {
            super(itemView);

            mCardView = (CardView) itemView.findViewById(R.id.card_book);
            mTitileView = (TextView) itemView.findViewById(R.id.book_title);
            mDescView = (TextView) itemView.findViewById(R.id.book_desc);
        }
    }
}
