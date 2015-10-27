package com.example.administrator.lglib.view.dialog;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import com.example.administrator.lglib.R;
import com.example.administrator.lglib.util.AppParameters;
import com.example.administrator.lglib.util.KeyBoardUtils;
import com.example.administrator.lglib.view.titleView.TitleBarView;

/**
 * 作者：gjj on 2015/10/27 11:12
 * 邮箱：app@1yd.me
 */
public class EditActivity extends Activity{
    private LinearLayout content_title_layout;
    private TitleBarView mTitleBarView;
    private String orgString="";
//    private EditTextInterFace edi;
    private EditText et_message;
//    /**
//     * 点击确定和返回的接口
//     */
//    public interface EditTextInterFace{
//        public void clickFinish(Activity activity,String message);
//        public void clickBack(Activity activity);
//    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_text);
        orgString=getIntent().getStringExtra("orgString");
        if(TextUtils.isEmpty(orgString)){
            orgString="";
        }
        initTitle();
        initGui();
        initListener();
    }
    private void initTitle(){
        content_title_layout= (LinearLayout) findViewById(R.id.content_title_layout);
        mTitleBarView = new TitleBarView(EditActivity.this);
        content_title_layout.addView(mTitleBarView.setup());
        mTitleBarView.setBackground(R.color.title_bar_bac);//设置背景资源
        mTitleBarView.setTitle(R.string.title);
        mTitleBarView.setLeftButton(R.mipmap.title_left_ben_seler, 0, R.string.back);
        mTitleBarView.setRightButton(0, 0, R.string.finish);
    }
    public void initGui(){
        et_message= (EditText) findViewById(R.id.et_message);
        et_message.setText(orgString);
        //打开软键盘
//        KeyBoardUtils.openKeybord(et_message, EditActivity.this);
    }
    private void initListener() {
        mTitleBarView.setLeftAction(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                KeyBoardUtils.closeKeybord(et_message, EditActivity.this);//软键盘隐藏
//                edi.clickBack(EditActivity.this);
            }
        });
        mTitleBarView.setRightAction(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                edi.clickFinish(EditActivity.this,et_message.getText().toString().trim());
                Intent intent=new Intent();
                intent.putExtra("orgString", et_message.getText().toString().trim());
                setResult(AppParameters.EDITACTIVITY_RESULT, intent);
                finish();
                KeyBoardUtils.closeKeybord(et_message, EditActivity.this);//软键盘隐藏
            }
        });
    }
}
