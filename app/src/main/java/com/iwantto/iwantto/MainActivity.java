package com.iwantto.iwantto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.iwantto.iwantto.jump.AActivity;

public class MainActivity extends AppCompatActivity {

    private Button mBtnUI;
    private Button mBtnLifeCycle;
    private Button mBtnJump;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBtnUI = (Button) findViewById(R.id.btn_ui);
        mBtnLifeCycle = findViewById(R.id.btn_lifecycle);
        mBtnJump = findViewById(R.id.btn_jump);
        setListeners();
    }
    private void setListeners(){
        OnClick onClick = new OnClick();
        mBtnUI.setOnClickListener(onClick);
        mBtnLifeCycle.setOnClickListener(onClick);
        mBtnJump.setOnClickListener(onClick);
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
                case R.id.btn_jump:
                    //跳转到AActivity演示界面
                    intent = new Intent(MainActivity.this, AActivity.class);
                    break;
            default:
            }
            startActivity(intent);
        }
    }
}
