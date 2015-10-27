package com.example.administrator.lglib.util;

import android.app.Activity;
import android.content.Intent;
import android.provider.MediaStore;
import android.view.View;
import android.widget.AdapterView;

import com.example.administrator.lglib.R;
import com.example.administrator.lglib.util.AppParameters;
import com.example.administrator.lglib.util.DialogUtil;
import com.example.administrator.lglib.view.imagescan.ImageMainActivity;
import com.flyco.dialog.listener.MyOnOperItemClickL;

/**
 * 作者：gjj on 2015/10/23 13:25
 * 邮箱：app@1yd.me
 */
public class PhotoDialogUtils {
    private Activity context;
    private View parent;
    String[] stringItems ;
    private boolean lookBigImage=false;
    private PhotoClickListener photoClickListener;
    public PhotoDialogUtils(Activity context,View parent,boolean lookBigImage,PhotoClickListener photoClickListener){
        this.context=context;
        this.parent=parent;
        this.photoClickListener=photoClickListener;
        this.lookBigImage=lookBigImage;
        stringItems=context.getResources().getStringArray(R.array.photo_string);
    }
    public interface PhotoClickListener{
        public void start_for_take_photo();
        public void start_for_local_photo();
//        public void start_for_lookBig_photo(Intent intent);
    }
    public void showPhotoDialog(){
        DialogUtil.ActionSheetDialogNoTitle(context, parent, stringItems, new MyOnOperItemClickL() {
            @Override
            public void onOperItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0://拍照
                        Intent openCameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                        context.startActivityForResult(openCameraIntent, AppParameters.PHOTOTAKE);// 拍照返回结果
                        break;
                    case 1://从相册选择
                        Intent image_activity = new Intent(context, ImageMainActivity.class);
                        context.startActivityForResult(image_activity, AppParameters.PHOTOZOOM);// 相册选择返回结果
                        break;
                    default:
                        break;
                }
            }
        });
    }
}
