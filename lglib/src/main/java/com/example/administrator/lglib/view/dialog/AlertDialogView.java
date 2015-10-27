package com.example.administrator.lglib.view.dialog;

import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.administrator.lglib.R;
import com.example.administrator.lglib.util.AppParameters;
import com.example.administrator.lglib.util.KeyBoardUtils;
import com.example.administrator.lglib.util.StringUtils;

public class AlertDialogView {
	public static EditText  messageTextView;
	public static Dialog showAlertView(final Context mContext,String type,String title, String message, final ViewClickListener cancelListener, final ViewClickListener okListener) {
		final Dialog dialog = new Dialog(mContext, R.style.alertDialogView);

		LayoutInflater inflater = LayoutInflater.from(mContext);
		View view = (View) inflater.inflate(R.layout.alertdialog_view, null);

		// 标题和内容
		TextView titleTextView = (TextView) view.findViewById(R.id.titleTextView);
		messageTextView = (EditText) view.findViewById(R.id.et_context);
		Button btn_cancel= (Button) view.findViewById(R.id.btn_cancel);
		Button btn_ok= (Button) view.findViewById(R.id.btn_ok);

		//打开软键盘
		KeyBoardUtils.openKeybord(messageTextView, mContext);

		//设置输入的类型
		if(TextUtils.isEmpty(type)){
			messageTextView.setInputType(EditorInfo.TYPE_CLASS_TEXT);//文字类
		}else if(AppParameters.NUMBER.equals(type)){
			messageTextView.setInputType(EditorInfo.TYPE_CLASS_NUMBER);//数字
		}else if(AppParameters.NUMBER.equals(type)){
			messageTextView.setInputType(EditorInfo.TYPE_TEXT_VARIATION_PASSWORD);//密码
		}else{//其他类型也是文字
			messageTextView.setInputType(EditorInfo.TYPE_CLASS_TEXT);//文字类
		}


		if(TextUtils.isEmpty(title)){
			titleTextView.setText("请输入");
		}else{
			titleTextView.setText(title);
		}
		if(TextUtils.isEmpty(message)){//message用于输入和回显
			messageTextView.setText("");
		}else{
			messageTextView.setText(message);
		}

		btn_cancel.setOnClickListener(new OnClickListener() {//取消
			@Override
			public void onClick(View v) {
				KeyBoardUtils.closeKeybord(messageTextView, mContext);//软键盘隐藏
				if(dialog!=null){
					dialog.dismiss();
				}
				if(cancelListener!=null){
					cancelListener.OnViewClick(messageTextView.getText().toString().trim());
				}

			}
		});
		btn_ok.setOnClickListener(new OnClickListener() {//确定
			@Override
			public void onClick(View v) {
				KeyBoardUtils.closeKeybord(messageTextView, mContext);//软键盘隐藏
				if(dialog!=null){
					dialog.dismiss();
				}
				if(okListener!=null){
					okListener.OnViewClick(messageTextView.getText().toString().trim());
				}
			}
		});
		final int viewWidth = StringUtils.dip2px(mContext, 250);
		view.setMinimumWidth(viewWidth);

		dialog.setCanceledOnTouchOutside(false);

		dialog.setContentView(view);
		dialog.show();
		return dialog;
	}

	public interface ViewClickListener {
		void OnViewClick(String message);
	}

}
