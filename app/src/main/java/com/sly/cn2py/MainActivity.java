package com.sly.cn2py;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.sly.pylibrary.Cn2Py;

import static com.sly.cn2py.R.id.ac_main_edit;

public class MainActivity extends AppCompatActivity {

    private EditText inputEtv;
    private TextView showTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUI();
    }

    private void initUI() {
        inputEtv = (EditText) findViewById(ac_main_edit);
        showTv = (TextView) findViewById(R.id.ac_main_show);
    }

    public void onClick(View view) {
        String text = inputEtv.getText().toString();
        if (TextUtils.isEmpty(text)) {
            Snackbar.make(view, "输入不能为空", Snackbar.LENGTH_SHORT).show();
            return;
        }
        switch (view.getId()) {
            case R.id.ac_main_btn01:
                //获取中文字符串第一个字的首字母:根字母
                showTv.setText(Cn2Py.getRootChar(text));
                break;
            case R.id.ac_main_btn02:
                //获取中文字符串每个字的首字母：缩写
                showTv.setText(Cn2Py.getIndexPinYin(text));
                break;
            case R.id.ac_main_btn03:
                //获取中文字符串的全拼
                showTv.setText(Cn2Py.getFullPinYin(text));
                break;
        }
    }
}
