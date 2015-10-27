package com.example.administrator.lglib.view.imagescan;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;

import com.example.administrator.lglib.R;
import com.example.administrator.lglib.util.AppParameters;

import java.util.List;


public class ShowImageActivity extends Activity {
	private GridView mGridView;
	private List<String> list;
	private ChildAdapter adapter;
	private boolean click=false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.show_image_activity);
		
		mGridView = (GridView) findViewById(R.id.child_grid);
		list = getIntent().getStringArrayListExtra("data");
		click=getIntent().getBooleanExtra("click", false);
		adapter = new ChildAdapter(this, list, mGridView,click);
		mGridView.setAdapter(adapter);
		if(click){
			mGridView.setOnItemClickListener(new OnItemClickListener() {

				@Override
				public void onItemClick(AdapterView<?> arg0, View arg1,
						int arg2, long arg3) {
					Intent intent=new Intent();
					intent.putExtra("child_path", list.get(arg2));
					setResult(AppParameters.SHOW_IMAGE_ACTIVITY_RESULT_CODE, intent);
					finish();
				}
			});
		}
		
	}

	@Override
	public void onBackPressed() {
		super.onBackPressed();
	}
	
	

	
}
