package com.example.okgoactivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.okgoactivity.JavaBean.TestBean;
import com.example.okgoactivity.callback.DialogCallback;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.cache.CacheMode;
import com.lzy.okgo.model.Response;

public class MainActivity extends AppCompatActivity {

    private String url="http://v.juhe.cn/joke/content/list.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        inData();

    }

    private void inData() {
        OkGo.<TestBean>get(url)
                .tag(this)
                .cacheKey("cacheKey")
                .cacheMode(CacheMode.NO_CACHE)
                .params("pagesize","10")
                .params("sort","asc")
                .params("page","2")
                .params("key","dbd73ff1ac2e78d77d7e38da2741d205")
                .params("time","1418745237")
                .execute(new DialogCallback<TestBean>(this) {
                    @Override
                    public void onSuccess(Response<TestBean> response) {
                        String error_code = response.body().getReason();
                        Log.e("TAG",error_code+"---");


                    }

                    @Override
                    public void onFinish() {
                        super.onFinish();
                    }
                });
    }
}
