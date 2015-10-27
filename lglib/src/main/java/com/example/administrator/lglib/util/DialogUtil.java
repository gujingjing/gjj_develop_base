package com.example.administrator.lglib.util;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.AdapterView;

import com.example.administrator.lglib.R;
import com.flyco.animation.BaseAnimatorSet;
import com.flyco.animation.BounceEnter.BounceTopEnter;
import com.flyco.animation.SlideExit.SlideBottomExit;
import com.flyco.dialog.adapter.TestAdapter;
import com.flyco.dialog.entity.DialogMenuItem;
import com.flyco.dialog.listener.MyOnBtnClickL;
import com.flyco.dialog.listener.MyOnOperItemClickL;
import com.flyco.dialog.listener.OnBtnClickL;
import com.flyco.dialog.listener.OnOperItemClickL;
import com.flyco.dialog.widget.ActionSheetDialog;
import com.flyco.dialog.widget.MaterialDialog;
import com.flyco.dialog.widget.NormalDialog;
import com.flyco.dialog.widget.NormalListDialog;

import java.util.ArrayList;

/**
 * 作者：lg on 2015-10-22 16:00
 * 邮箱：support@1yd.me
 */
public class DialogUtil {
    /**************************两个按钮=====**********************************/
    /**
     * NormalDialogStyleTwo 两个按钮设置所有的属性
     */
    public static Dialog LG_NormalDialogStyleTwoAll(Context context, BaseAnimatorSet bas_in, BaseAnimatorSet bas_out, String message, String leftText, String rightText, final MyOnBtnClickL leftListener, final MyOnBtnClickL rightListener) {
//        BaseAnimatorSet bas_in = new BounceTopEnter();
//        BaseAnimatorSet bas_out = new SlideBottomExit();
        final NormalDialog dialog = new NormalDialog(context);
        dialog.content(message)//
                .btnText(leftText, rightText)//
                .style(NormalDialog.STYLE_TWO)//
                .titleTextSize(23)//
                .showAnim(bas_in)//
                .dismissAnim(bas_out)//
                .show();
        dialog.setOnBtnClickL(
                new OnBtnClickL() {
                    @Override
                    public void onBtnClick() {
//                        T.showShort(context, "left");
                        dialog.dismiss();
                        if (leftListener != null) {
                            leftListener.onBtnClick();
                        }
                    }
                },
                new OnBtnClickL() {
                    @Override
                    public void onBtnClick() {
//                        T.showShort(context, "right");
                        dialog.dismiss();
                        if (rightListener != null) {
                            rightListener.onBtnClick();
                        }
                    }
                });
        return dialog;
    }

    /**
     * NormalDialogStyleTwo 两个按钮设置信息属性(除了设置动画)
     */
    public static Dialog LG_NormalDialogStyleTwoBaseAnimaAll(Context context, String message, String leftText, String rightText, final MyOnBtnClickL leftListener, final MyOnBtnClickL rightListener) {
        BaseAnimatorSet bas_in = new BounceTopEnter();
        BaseAnimatorSet bas_out = new SlideBottomExit();
        final NormalDialog dialog = new NormalDialog(context);
        dialog.content(message)//
                .btnText(leftText, rightText)//
                .style(NormalDialog.STYLE_TWO)//
                .titleTextSize(23)//
                .showAnim(bas_in)//
                .dismissAnim(bas_out)//
                .show();
        dialog.setOnBtnClickL(
                new OnBtnClickL() {
                    @Override
                    public void onBtnClick() {
//                        T.showShort(context, "left");
                        dialog.dismiss();
                        if (leftListener != null) {
                            leftListener.onBtnClick();
                        }
                    }
                },
                new OnBtnClickL() {
                    @Override
                    public void onBtnClick() {
//                        T.showShort(context, "right");
                        dialog.dismiss();
                        if (rightListener != null) {
                            rightListener.onBtnClick();
                        }
                    }
                });
        return dialog;
    }

    /**
     * NormalDialogStyleTwo 两个按钮设置(信息，和点击事件)
     * left 取消
     * right 确定
     */
    public static Dialog LG_NormalDialogStyleTwoMessageClick(Context context, String message, final MyOnBtnClickL leftListener, final MyOnBtnClickL rightListener) {
        BaseAnimatorSet bas_in = new BounceTopEnter();
        BaseAnimatorSet bas_out = new SlideBottomExit();
        final NormalDialog dialog = new NormalDialog(context);
        dialog.content(message)//
                .btnText("取消", "确定")//
                .style(NormalDialog.STYLE_TWO)//
                .titleTextSize(23)//
                .showAnim(bas_in)//
                .dismissAnim(bas_out)//
                .show();
        dialog.setOnBtnClickL(
                new OnBtnClickL() {
                    @Override
                    public void onBtnClick() {
//                        T.showShort(context, "left");
                        dialog.dismiss();
                        if (leftListener != null) {
                            leftListener.onBtnClick();
                        }
                    }
                },
                new OnBtnClickL() {
                    @Override
                    public void onBtnClick() {
//                        T.showShort(context, "right");
                        dialog.dismiss();
                        if (rightListener != null) {
                            rightListener.onBtnClick();
                        }
                    }
                });
        return dialog;
    }

    /**
     * 两个按钮（设置成的文字描述,只提供展示）
     */
    public static Dialog LG_MaterialDialogDefaultTextShow(Context context, String message) {
        final MaterialDialog dialog = new MaterialDialog(context);
        BaseAnimatorSet bas_in = new BounceTopEnter();
        BaseAnimatorSet bas_out = new SlideBottomExit();
        dialog.content(message)//
                .btnText("取消", "确定")//
                .showAnim(bas_in)//
                .dismissAnim(bas_out)//
                .show();

        dialog.setOnBtnClickL(
                new OnBtnClickL() {//left btn click listener
                    @Override
                    public void onBtnClick() {
                        dialog.dismiss();
                    }
                },
                new OnBtnClickL() {//right btn click listener
                    @Override
                    public void onBtnClick() {
                        dialog.dismiss();
                    }
                }
        );
        return dialog;
    }

    /**
     * 两个按钮（设置成的文字描述,只提供展示）
     */
    public static Dialog LG_MaterialDialogDefaultTextShowAndClick(Context context, String message, String leftText, String rightText, final MyOnBtnClickL leftListener, final MyOnBtnClickL rightListener) {
        final MaterialDialog dialog = new MaterialDialog(context);
        BaseAnimatorSet bas_in = new BounceTopEnter();
        BaseAnimatorSet bas_out = new SlideBottomExit();
        dialog.content(message)//
                .btnText(leftText, rightText)//
                .showAnim(bas_in)//
                .dismissAnim(bas_out)//
                .show();

        dialog.setOnBtnClickL(
                new OnBtnClickL() {//left btn click listener
                    @Override
                    public void onBtnClick() {
                        dialog.dismiss();
                        if (leftListener != null) {
                            leftListener.onBtnClick();
                        }
                    }
                },
                new OnBtnClickL() {//right btn click listener
                    @Override
                    public void onBtnClick() {
                        dialog.dismiss();
                        if (rightListener != null) {
                            rightListener.onBtnClick();
                        }
                    }
                }
        );
        return dialog;
    }

    /************************************************一个按钮=======oneButton*****************************************************************/
    /**
     * 设置一个按钮的显示
     */
    public static Dialog LG_NormalDialogOneBtn(Context context, String message, String btnText, final MyOnBtnClickL btnListener) {
        final NormalDialog dialog = new NormalDialog(context);
        BaseAnimatorSet bas_in = new BounceTopEnter();
        BaseAnimatorSet bas_out = new SlideBottomExit();
        dialog.content(message)//
                .btnNum(1)
                .btnText(btnText)//
                .showAnim(bas_in)//
                .dismissAnim(bas_out)//
                .show();

        dialog.setOnBtnClickL(new OnBtnClickL() {
            @Override
            public void onBtnClick() {
                dialog.dismiss();
                if (btnListener != null) {
                    btnListener.onBtnClick();
                }
            }
        });
        return dialog;
    }

    /**
     * 设置一个按钮(文字描述)
     */
    public static Dialog LG_MaterialDialogOneBtn(Context context, String message, String btnText, final MyOnBtnClickL btnListener) {
        final MaterialDialog dialog = new MaterialDialog(context);
        BaseAnimatorSet bas_in = new BounceTopEnter();
        BaseAnimatorSet bas_out = new SlideBottomExit();
        dialog//
                .btnNum(1)
                .content(message)//
                .btnText(btnText)//
                .showAnim(bas_in)//
                .dismissAnim(bas_out)//
                .show();

        dialog.setOnBtnClickL(new OnBtnClickL() {
            @Override
            public void onBtnClick() {
                dialog.dismiss();
                if (btnListener != null) {
                    btnListener.onBtnClick();
                }
            }
        });
        return dialog;
    }
    /************************************************三个按钮=======threeButton*****************************************************************/
    /**
     * 设置三个按钮
     */
    public static Dialog LG_MaterialDialogThreeBtns(Context context, String message, String leftText, String midText, String rightText, final MyOnBtnClickL leftListener, final MyOnBtnClickL midListener, final MyOnBtnClickL rightListener) {
        final MaterialDialog dialog = new MaterialDialog(context);
        BaseAnimatorSet bas_in = new BounceTopEnter();
        BaseAnimatorSet bas_out = new SlideBottomExit();
        dialog.isTitleShow(false)//
                .btnNum(3)
                .content(message)//
                .btnText(leftText, midText, rightText)//
                .showAnim(bas_in)//
                .dismissAnim(bas_out)//
                .show();

        dialog.setOnBtnClickL(
                new OnBtnClickL() {//left btn click listener
                    @Override
                    public void onBtnClick() {
                        dialog.dismiss();
                        if (leftListener != null) {
                            leftListener.onBtnClick();
                        }
                    }
                },
                new OnBtnClickL() {//right btn click listener
                    @Override
                    public void onBtnClick() {
                        dialog.dismiss();
                        if (rightListener != null) {
                            rightListener.onBtnClick();
                        }
                    }
                }
                ,
                new OnBtnClickL() {//middle btn click listener
                    @Override
                    public void onBtnClick() {
                        dialog.dismiss();
                        if (midListener != null) {
                            midListener.onBtnClick();
                        }
                    }
                }
        );
        return dialog;
    }

    /************************************************列表的集合=======listButton*****************************************************************/
    /**
     * listLie前面表带图片
     * testItems.add(new DialogMenuItem("收藏", R.mipmap.ic_winstyle_favor));//demo
     */
    public static Dialog LG_NormalListDialogCustomAttr(Context context, ArrayList<DialogMenuItem> testItems, final MyOnOperItemClickL myOnOperItemClickL) {
        final NormalListDialog dialog = new NormalListDialog(context, testItems);
        dialog.title("请选择")//
                .titleTextSize_SP(18)//
                .titleBgColor(Color.parseColor("#409ED7"))//
                .itemPressColor(Color.parseColor("#85D3EF"))//
                .itemTextColor(Color.parseColor("#303030"))//
                .itemTextSize(14)//
                .cornerRadius(0)//
                .widthScale(0.8f)//
                .show(R.style.myDialogAnim);

        dialog.setOnOperItemClickL(new OnOperItemClickL() {
            @Override
            public void onOperItemClick(AdapterView<?> parent, View view, int position, long id) {
//                T.showShort(context, testItems.get(position).operName);
                dialog.dismiss();
                if (myOnOperItemClickL != null) {
                    myOnOperItemClickL.onOperItemClick(parent, view, position, id);
                }
            }
        });
        return dialog;
    }

    /**
     * listLie String文字集合
     * testItems.add(new DialogMenuItem("收藏", R.mipmap.ic_winstyle_favor));//demo
     */
    public static Dialog LG_NormalStringListDialogAdapter(Context context, ArrayList<DialogMenuItem> testItems, final MyOnOperItemClickL myOnOperItemClickL) {
        final NormalListDialog dialog = new NormalListDialog(context, new TestAdapter(context, testItems));
        dialog.title("请选择")//
                .titleTextSize_SP(18)//
                .titleBgColor(Color.parseColor("#409ED7"))//
                .itemPressColor(Color.parseColor("#85D3EF"))//
                .itemTextColor(Color.parseColor("#303030"))//
                .itemTextSize(14)//
                .cornerRadius(0)//
                .widthScale(0.8f)//
                .show(R.style.myDialogAnim);
        dialog.setOnOperItemClickL(new OnOperItemClickL() {
            @Override
            public void onOperItemClick(AdapterView<?> parent, View view, int position, long id) {
//                T.showShort(context, testItems.get(position).operName);
                dialog.dismiss();
                if (myOnOperItemClickL != null) {
                    myOnOperItemClickL.onOperItemClick(parent, view, position, id);
                }
            }
        });
        return dialog;
    }
    /************************************************底部item集合=======buttonButton*****************************************************************/
    /**
     * 底部弹起的按钮lie表
     * final String[] stringItems = {"接收消息并提醒", "接收消息但不提醒", "收进群助手且不提醒", "屏蔽群消息"};
     */
    public static Dialog LG_ActionSheetDialog(Context context,String titleText,String[] stringItems,final MyOnOperItemClickL myOnOperItemClickL) {
        final ActionSheetDialog dialog = new ActionSheetDialog(context, stringItems, null);
//        dialog.title("选择群消息提醒方式\r\n(该群在电脑的设置:接收消息并提醒)")//
        dialog.title(titleText)//
                .titleTextSize_SP(14.5f)//
                .show();

        dialog.setOnOperItemClickL(new OnOperItemClickL() {
            @Override
            public void onOperItemClick(AdapterView<?> parent, View view, int position, long id) {
                dialog.dismiss();
                if(myOnOperItemClickL!=null){
                    myOnOperItemClickL.onOperItemClick(parent,view,position,id);
                }
            }
        });
        return dialog;
    }
    /**
     * 底部弹起的按钮lie表(不带标题)
     * final String[] stringItems = {"接收消息并提醒", "接收消息但不提醒", "收进群助手且不提醒", "屏蔽群消息"};
     * view 为整个全局的view
     */
    public static Dialog ActionSheetDialogNoTitle(Context context,View view,String[] stringItems,final MyOnOperItemClickL myOnOperItemClickL) {
        final ActionSheetDialog dialog = new ActionSheetDialog(context, stringItems, view);
        dialog.isTitleShow(false).show();

        dialog.setOnOperItemClickL(new OnOperItemClickL() {
            @Override
            public void onOperItemClick(AdapterView<?> parent, View view, int position, long id) {
                dialog.dismiss();
                if(myOnOperItemClickL!=null){
                    myOnOperItemClickL.onOperItemClick(parent,view,position,id);
                }
            }
        });
        return dialog;
    }

}
