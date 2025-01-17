/*
 * Copyright 2016 jeasonlzy(廖子尧)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.okgoactivity.callback;

import android.app.Activity;
import android.app.ProgressDialog;
import android.view.Window;

import com.example.okgoactivity.R;
import com.lzy.okgo.request.base.Request;

/**
 * ================================================
 * 描    述：：带进度条的默认将返回的数据解析成需要的Bean,可以是 BaseBean，String，List，Map

 * 修订历史：
 * ================================================
 */
public abstract class DialogCallback<T> extends JsonCallback<T> {

    private ProgressDialog dialog;
    private void initDialog(Activity activity) {
        dialog = new ProgressDialog(activity, R.style.CustomProgressDialog);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCanceledOnTouchOutside(false);
        dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        dialog.setMessage("请求网络中...");

    }

    public DialogCallback(Activity activity) {
        super();
        initDialog(activity);
    }

    @Override
    public void onStart(Request<T, ? extends Request> request) {
        if (dialog != null && !dialog.isShowing()) {
            dialog.show();
            dialog.setContentView(R.layout.view_progress);
        }
    }

    @Override
    public void onFinish() {
        //网络请求结束后关闭对话框
        if (dialog != null && dialog.isShowing()) {
            dialog.dismiss();
        }
    }
}
