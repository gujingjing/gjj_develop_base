//package com.lg.lib;
//
//import android.app.Activity;
//import android.os.Bundle;
//import android.widget.ListView;
//import android.widget.Toast;
//
//import com.cjj.MaterialRefreshLayout;
//import com.cjj.MaterialRefreshListener;
//
///**
// * 作者：gjj on 2015/10/27 16:54
// * 邮箱：app@1yd.me
// */
//public class TestActivity extends Activity{
//    private MaterialRefreshLayout materialRefreshLayout;
//    private ListView list;
//    private String[] array;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.test);
//        String[] array = new String[50];
//        for (int i = 0; i < array.length; i++) {
//            array[i] = "cjj " + i;
//        }
//        materialRefreshLayout= (MaterialRefreshLayout) findViewById(R.id.refresh);
//        list= (ListView) findViewById(R.id.list);
//
//        list.setAdapter(new android.widget.ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, array));
//        materialRefreshLayout.setLoadMore(true);//设置可以加载更多
//        materialRefreshLayout.finishRefreshLoadMore();//取消加载更多的显示
//        materialRefreshLayout.setMaterialRefreshListener(new MaterialRefreshListener() {
//            @Override
//            public void onRefresh(final MaterialRefreshLayout materialRefreshLayout) {//下拉刷新
//                materialRefreshLayout.postDelayed(new Runnable() {
//                    @Override
//                    public void run() {
//                        materialRefreshLayout.finishRefresh();
//
//                    }
//                }, 3000);
//            }
//
//            @Override
//            public void onfinish() {
//                Toast.makeText(TestActivity.this, "finish", Toast.LENGTH_LONG).show();
//            }
//            @Override
//            public void onRefreshLoadMore(final MaterialRefreshLayout materialRefreshLayout) {//加载更多
//                super.onRefreshLoadMore(materialRefreshLayout);
//                Toast.makeText(TestActivity.this, "load more", Toast.LENGTH_LONG).show();
//                materialRefreshLayout.postDelayed(new Runnable() {
//                    @Override
//                    public void run() {
//                        materialRefreshLayout.finishRefreshLoadMore();
//
//                    }
//                }, 3000);
//            }
//        });
//    }
//}
