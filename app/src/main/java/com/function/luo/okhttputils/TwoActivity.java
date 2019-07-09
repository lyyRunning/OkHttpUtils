package com.function.luo.okhttputils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Callback;

import okhttp3.Request;

import okhttp3.Response;


/**
 * Created by luo on 2019/7/8.
 */

public class TwoActivity extends Activity {

    @BindView(R.id.tv_message)
    TextView tvMessage;
    @BindView(R.id.bt_request1)
    Button btRequest1;
    @BindView(R.id.bt_request2)
    Button btRequest2;
    @BindView(R.id.bt_request3)
    Button btRequest3;
    @BindView(R.id.bt_request4)
    Button btRequest4;
    @BindView(R.id.bt_request5)
    Button btRequest5;
    @BindView(R.id.bt_request6)
    Button btRequest6;
    @BindView(R.id.bt_next)
    Button btNext;
    private String TAG = "LUO";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        btNext.setVisibility(View.GONE);
    }

    @OnClick({R.id.bt_request1, R.id.bt_request2, R.id.bt_request3, R.id.bt_request4, R.id.bt_request5, R.id.bt_request6})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt_request1:
                getAsyncOkHttp();
                break;
            case R.id.bt_request2:
                break;
            case R.id.bt_request3:
                break;
            case R.id.bt_request4:
                break;
            case R.id.bt_request5:
                break;
            case R.id.bt_request6:
                break;
        }
    }


    /**
     * 异步 GET 请求
     */
    private void getAsyncOkHttp() {
        String url = "http://wwww.baidu.com";


        final Request request = new Request.Builder()
                .url(url)
                .get()//默认就是GET请求，可以不写
                .build();
        Call call = HttpUtil.getHttpInstance().newCall(request);

        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.d(TAG, "onFailure: " + e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.d(TAG, "onResponse: " + response.body().string());
            }
        });
    }


    public static void launch(Context mContext) {
        Intent intent = new Intent(mContext,TwoActivity.class);
        mContext.startActivity(intent);
    }
}
