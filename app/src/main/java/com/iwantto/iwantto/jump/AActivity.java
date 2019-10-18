package com.iwantto.iwantto.jump;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.iwantto.iwantto.R;

public class AActivity extends AppCompatActivity {

    private Button mBtnJump;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);
        Log.d("AActivity","----onCreate----");
        Log.d("AActivity","taskid:"+getTaskId()+" ,hash:"+hashCode());
        logtaskName();
        mBtnJump = findViewById(R.id.jump);
        mBtnJump.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //显式1
                Intent intent = new Intent(AActivity.this,BActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("name","申哥");
                bundle.putInt("number",88);
                intent.putExtras(bundle);
                startActivity(intent);
//                startActivityForResult(intent,0);

                //显式2
//                Intent intent = new Intent();
//                intent.setClass(AActivity.this,BActivity.class);
//                startActivity(intent);

                //显式3
//                Intent intent = new Intent();
//                intent.setClassName(AActivity.this,"com.iwantto.iwantto.jump.BActivity");
//                startActivity(intent);

                //显式4
//                Intent intent = new Intent();
//                intent.setComponent(new ComponentName(AActivity.this,"com.iwantto.iwantto.jump.BActivity"));
//                startActivity(intent);

                //隐式
//                Intent intent = new Intent();
//                intent.setAction("com.iwantto.test.BActivity");
//                startActivity(intent);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Toast.makeText(AActivity.this,data.getExtras().getString("title"),Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.d("AActivity","----onNewIntent----");
        Log.d("AActivity","taskid:"+getTaskId()+" ,hash:"+hashCode());
        logtaskName();
    }

    private void logtaskName(){
        try {
            ActivityInfo info = getPackageManager().getActivityInfo(getComponentName(), PackageManager.GET_META_DATA);
            Log.d("AActivity",info.taskAffinity);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }
}
