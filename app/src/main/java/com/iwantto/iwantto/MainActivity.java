package com.iwantto.iwantto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button mBtnUI;
    private Button mBtnLifeCycle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBtnUI = (Button) findViewById(R.id.btn_ui);
        mBtnLifeCycle = findViewById(R.id.btn_lifecycle);
        setListeners();
    }
    private void setListeners(){
        OnClick onClick = new OnClick();
        mBtnUI.setOnClickListener(onClick);
        mBtnLifeCycle.setOnClickListener(onClick);
    }
    private class OnClick implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            Intent intent = null;
            switch (view.getId()){
                case R.id.btn_ui:
                    //跳转到UI演示界面
                    intent = new Intent(MainActivity.this, UIActivity.class);
                break;
                case R.id.btn_lifecycle:
                    //跳转到LifeCycle演示界面
                    intent = new Intent(MainActivity.this, LifeCycleActivity.class);
                break;
            default:
            }
            startActivity(intent);
        }
    }
}
