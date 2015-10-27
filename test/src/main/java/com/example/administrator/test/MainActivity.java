package com.example.administrator.test;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.cjj.MaterialRefreshLayout;
import com.cjj.MaterialRefreshListener;

public class MainActivity extends Activity {
    private MaterialRefreshLayout materialRefreshLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String[] array = new String[50];
        for (int i = 0; i < array.length; i++) {
            array[i] = "cjj " + i;
        }

        final ListView listView = (ListView) findViewById(R.id.lv);
        listView.setAdapter(new android.widget.ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, array));
        materialRefreshLayout = (MaterialRefreshLayout) findViewById(R.id.refresh);
        materialRefreshLayout.setLoadMore(true);
        materialRefreshLayout.finishRefreshLoadMore();

        materialRefreshLayout.setMaterialRefreshListener(new MaterialRefreshListener() {
            @Override
            public void onRefresh(final MaterialRefreshLayout materialRefreshLayout) {
                materialRefreshLayout.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        materialRefreshLayout.finishRefresh();

                    }
                }, 3000);

            }

            @Override
            public void onfinish() {
                Toast.makeText(MainActivity.this, "finish", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onRefreshLoadMore(final MaterialRefreshLayout materialRefreshLayout) {
                Toast.makeText(MainActivity.this, "load more", Toast.LENGTH_LONG).show();
                materialRefreshLayout.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        materialRefreshLayout.finishRefreshLoadMore();

                    }
                }, 3000);
            }
        });
    }

}
