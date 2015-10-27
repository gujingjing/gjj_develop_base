package com.example.administrator.lglib.http.callback;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * 作者：lg on 2015-10-22 16:18
 * 邮箱：support@1yd.me
 */
public abstract class BaseCallBack <T> implements Callback<T> {
    @Override
    public void success(T t, Response response) {
        onSuccess(t);
        onEnd();
    }
    @Override
    public void failure(RetrofitError retrofitError) {
        onFail(retrofitError);
        onEnd();
    }
    public abstract void onSuccess(T t);
    public abstract void onFail(RetrofitError retrofitError);
    public abstract void onEnd();
}
