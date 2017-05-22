package com.github.uiautomatortestapp;

import android.content.res.AssetManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.github.uiautomatortestapp.bean.Books;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rv_book_list);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        RecyclerAdpater adpater = new RecyclerAdpater(this);
        recyclerView.setAdapter(adpater);

        String booksStr = getBooks();
        Books books = null;
        try {
            books = new Gson().fromJson(booksStr,Books.class);
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
        }
        adpater.setData(books);
    }

    public String getBooks(){
        AssetManager assets = getAssets();
        StringBuilder sb = new StringBuilder();
        try {
            InputStream books = assets.open("books");
            BufferedReader br = new BufferedReader(new InputStreamReader(books));
            String line;
            while ((line=br.readLine())!=null){
                sb.append(line);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
}
