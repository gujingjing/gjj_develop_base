package com.lg.lib;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.cjj.MaterialRefreshLayout;
import com.cjj.MaterialRefreshListener;
import com.example.administrator.lglib.util.AppParameters;
import com.example.administrator.lglib.util.DialogUtil;
import com.example.administrator.lglib.view.dialog.AlertDialogView;
import com.flyco.dialog.listener.MyOnBtnClickL;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    private Button btn;
    private ImageView iv;
    private ExpandableListView expandableListView;
    private List<String>groupArray ;
    private ArrayList<List<String>>childArray;
    private MaterialRefreshLayout materialRefreshLayout;
    private ListView list;
    private String[] array;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn= (Button) findViewById(R.id.btn);
        iv= (ImageView) findViewById(R.id.iv);
        expandableListView= (ExpandableListView) findViewById(R.id.expandableListView);
        materialRefreshLayout= (MaterialRefreshLayout) findViewById(R.id.refresh);
        list= (ListView) findViewById(R.id.list);

        String[] array = new String[50];
        for (int i = 0; i < array.length; i++) {
            array[i] = "cjj " + i;
        }
        Glide.with(MainActivity.this)
                .load("http://inthecheesefactory.com/uploads/source/glidepicasso/cover.jpg")//加载网络图片
                .placeholder(R.mipmap.loading)//加载中显示的图片
                .error(R.mipmap.friends_sends_pictures_no)//加载错误显示的图片
                .centerCrop()
                .crossFade()
//                .fitCenter()
//                .diskCacheStrategy(DiskCacheStrategy.ALL)//让Glide既缓存全尺寸又缓存其他尺寸：
                .transform(new GlideCircleTransform(MainActivity.this))
                .into(iv)
//                .notify()
        ;
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent=new Intent(MainActivity.this, EditActivity.class);
//                startActivityForResult(intent, AppParameters.EDITACTIVITY_REAUEST);
                DialogUtil.LG_NormalDialogStyleTwoMessageClick(MainActivity.this, "测试用的", new MyOnBtnClickL() {
                    @Override
                    public void onBtnClick() {
                        Toast.makeText(MainActivity.this, "left", Toast.LENGTH_SHORT).show();
                    }
                }, new MyOnBtnClickL() {
                    @Override
                    public void onBtnClick() {
                        Toast.makeText(MainActivity.this, "right", Toast.LENGTH_SHORT).show();
//                        Intent intent1=new Intent(MainActivity.this,TestActivity.class);
//                        startActivity(intent1);
                    }
                });
                AlertDialogView.showAlertView(MainActivity.this, AppParameters.NUMBER, "标题", "回显", null, null).show();
            }
        });
        initDate();
        expandableListView.setAdapter(new ExpandaAdapter());

//        initRefresh();
    }
    public void initRefresh(){
        list.setAdapter(new android.widget.ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, array));
        materialRefreshLayout.setLoadMore(true);//设置可以加载更多
        materialRefreshLayout.finishRefreshLoadMore();//取消加载更多的显示
        materialRefreshLayout.setMaterialRefreshListener(new MaterialRefreshListener() {
            @Override
            public void onRefresh(final MaterialRefreshLayout materialRefreshLayout) {//下拉刷新
                materialRefreshLayout.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        materialRefreshLayout.finishRefresh();

                    }
                }, 3000);
                materialRefreshLayout.finishRefreshLoadMore();
            }

            @Override
            public void onfinish() {
                Toast.makeText(MainActivity.this, "finish", Toast.LENGTH_LONG).show();
            }
            @Override
            public void onRefreshLoadMore(final MaterialRefreshLayout materialRefreshLayout) {//加载更多
                super.onRefreshLoadMore(materialRefreshLayout);
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
    public void initDate(){
        groupArray = new ArrayList<String>();
        childArray = new  ArrayList<List<String>>();

        groupArray.add("第一行" );
        groupArray.add("第二行" );

        List<String> tempArray = new  ArrayList<String>();
        tempArray.add("第一条" );
        tempArray.add("第二条" );
        tempArray.add("第三条" );

        for (int  index = 0 ; index <groupArray.size(); ++index)
        {
            childArray.add(tempArray);
        }
    }
    public class ExpandaAdapter extends BaseExpandableListAdapter {

        @Override
        public int getGroupCount() {
            return groupArray.size();
        }

        @Override
        public int getChildrenCount(int groupPosition) {
            return childArray.get(groupPosition).size();
        }

        @Override
        public Object getGroup(int groupPosition) {
            return groupArray.get(groupPosition);
        }

        @Override
        public Object getChild(int groupPosition, int childPosition) {
            return childArray.get(groupPosition).get(childPosition);
        }

        @Override
        public long getGroupId(int groupPosition) {
            return groupPosition;
        }

        @Override
        public long getChildId(int groupPosition, int childPosition) {
            return childPosition;
        }

        @Override
        public boolean hasStableIds() {
            return false;
        }

        @Override
        public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
            String string = groupArray.get(groupPosition);
            TextView view=new TextView(MainActivity.this);
            view.setText(string);
            view.setHeight(300);
            return  view;
        }

        @Override
        public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
            String string = childArray.get(groupPosition).get(childPosition);
            TextView view=new TextView(MainActivity.this);
            view.setText(string);
            view.setHeight(300);
            return  view;
        }

        @Override
        public boolean isChildSelectable(int groupPosition, int childPosition) {
            return true;
        }
    }
}
