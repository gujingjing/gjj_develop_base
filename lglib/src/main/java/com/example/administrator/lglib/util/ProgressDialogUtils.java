package com.example.administrator.lglib.util;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Handler;
import android.os.Message;

import com.example.administrator.lglib.R;
import com.example.administrator.lglib.util.AppParameters;


public class ProgressDialogUtils {

	public static ProgressDialog progressBar; // 等待层.....

	public static ProgressDialog getInstance(Activity mActivity) {
		if(progressBar ==null)
		{
			progressBar = new ProgressDialog(mActivity);
		}
		return progressBar;
	}


	public static void loadWaitProgressBar(Activity mActivity ,String message) {
		progressBar = getInstance(mActivity);
//		VolleyTool.setQueueSize(0);
		progressBar.setProgressStyle(ProgressDialog.STYLE_SPINNER);
		progressBar.setMessage(message);
		progressBar.setIndeterminate(false);
		progressBar.setCanceledOnTouchOutside(false);
		progressBar.setCancelable(false);
		if (mActivity != null && !mActivity.isFinishing()) {
			progressBar.show();
		}

		// 防止程序长时间等待，2分钟后，关闭等待层
		new Thread() {
			public void run() {
				try {
					Thread.sleep(AppParameters.PROGRESS_WAITTING_TIME);
				} catch (Exception e) {
				}
				mHandler.sendEmptyMessage(0);
			}
		}.start();
	}

	public static void loadWaitProgressBar(Activity mActivity) {
		progressBar = getInstance(mActivity);
//		VolleyTool.setQueueSize(0);
		progressBar.setProgressStyle(ProgressDialog.STYLE_SPINNER);
		progressBar.setMessage(StringUtils.getStringById(mActivity, R.string.progress_message));
		progressBar.setIndeterminate(false);
		progressBar.setCancelable(false);
		if (mActivity != null && !mActivity.isFinishing()) {
			progressBar.show();
		}
		// 防止程序长时间等待，2分钟后，关闭等待层
		new Thread() {
			public void run() {
				try {
					Thread.sleep(AppParameters.PROGRESS_WAITTING_TIME);
				} catch (Exception e) {
				}
				if(progressBar!=null){
					mHandler.sendEmptyMessage(0);
				}
			}
		}.start();
	}

	public static Handler mHandler = new Handler() {
		public void handleMessage(Message msg) {
			dismissProgressBar();
		}
	};

	/**
	 * 关闭等待层
	 */
	public static void dismissProgressBar() {
		if (progressBar != null) {
			progressBar.dismiss();
		}
		progressBar=null;
	}
}
