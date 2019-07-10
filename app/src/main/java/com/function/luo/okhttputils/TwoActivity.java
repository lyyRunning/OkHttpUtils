package com.function.luo.okhttputils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.function.luo.okhttp.CallBackUtil;
import com.function.luo.okhttp.OkhttpUtil;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;


/**
 * Created by luo on 2019/7/8.
 * OKHttp 牛逼封装
 */

public class TwoActivity extends Activity {


    @BindView(R.id.tv_message)
    TextView tvMessage;
    @BindView(R.id.bt_request1)
    Button btRequest1;
    @BindView(R.id.bt_request2)
    Button btRequest2;
    String url = "https://www.baidu.com/";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
        ButterKnife.bind(this);

    }


    public static void launch(Context mContext) {
        Intent intent = new Intent(mContext, TwoActivity.class);
        mContext.startActivity(intent);
    }

    @OnClick({R.id.bt_request1, R.id.bt_request2})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt_request1:
                getData(url);
                break;
            case R.id.bt_request2:
                postData(url);
                break;
            default:
        }
    }


    private void postData(String url) {
        HashMap<String, String> paramsMap = new HashMap<>();
        paramsMap.put("title","title");
        paramsMap.put("desc","desc");
        OkhttpUtil.okHttpPost(url, paramsMap, new CallBackUtil.CallBackString() {
            @Override
            public void onFailure(Call call, Exception e) {
                Log.d("kwwl",e.getMessage());
            }

            @Override
            public void onResponse(String response) {
                Toast.makeText(TwoActivity.this,"Success",Toast.LENGTH_SHORT).show();
                Log.d("kwwl",response);
            }
        });
    }

    private void getData(String url) {
        OkhttpUtil.okHttpGet(url, new CallBackUtil.CallBackString() {
            @Override
            public void onFailure(Call call, Exception e) {
                Log.d("kwwl",e.getMessage());
            }

            @Override
            public void onResponse(String response) {
                Toast.makeText(TwoActivity.this,"Success",Toast.LENGTH_SHORT).show();
                Log.d("kwwl",response);
            }
        });
    }
}
