package com.example.yanzhuang.caculation;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.preference.DialogPreference;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity implements OnClickListener {
    ProgressBar pb;
    TextView et;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ActionBar ac = getSupportActionBar();
        if(ac!=null){
            ac.hide();
        }
        Button b1 = (Button) findViewById(R.id.b1);
        Button b2 = (Button) findViewById(R.id.b2);
        Button b3 = (Button) findViewById(R.id.b3);
        Button b4 = (Button) findViewById(R.id.b4);
        Button b5 = (Button) findViewById(R.id.b5);
        Button b6 = (Button) findViewById(R.id.b6);
        Button b7 = (Button) findViewById(R.id.b7);
        Button b8 = (Button) findViewById(R.id.b8);
        Button b9 = (Button) findViewById(R.id.b9);
        Button b10 = (Button) findViewById(R.id.b10);
        Button b11 = (Button) findViewById(R.id.b11);
        Button b12 = (Button) findViewById(R.id.b12);
        Button b13 = (Button) findViewById(R.id.b13);

        pb = (ProgressBar) findViewById(R.id.pb);
        et = (TextView) findViewById(R.id.tv2);

        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
        b5.setOnClickListener(this);
        b6.setOnClickListener(this);
        b7.setOnClickListener(this);
        b8.setOnClickListener(this);
        b9.setOnClickListener(this);
        b10.setOnClickListener(this);
        b11.setOnClickListener(this);
        b12.setOnClickListener(this);
        b13.setOnClickListener(this);


    }


    @Override
    public void onClick(View v) {
        String str = null;
        final Handler mHandler = new Handler() {

            public void handleMessage(Message msg) {

                switch (msg.what) {
                    case 0:
                        pb.setProgress(pb.getProgress() + 10);
                        pb.setVisibility(View.VISIBLE);
                        break;
                    default:
                        break;

                }

            }
        };

        switch (v.getId()) {
            case R.id.b1:
                str = et.getText().toString();
                et.setText(str + "1");
                break;
            case R.id.b2:
                str = et.getText().toString();
                et.setText(str + "2");
                break;
            case R.id.b3:
                str = et.getText().toString();
                et.setText(str + "3");
                break;
            case R.id.b4:
                str = et.getText().toString();
                et.setText(str + "4");
                break;
            case R.id.b5:
                str = et.getText().toString();
                et.setText(str + "5");
                break;
            case R.id.b6:
                str = et.getText().toString();
                et.setText(str + "6");
                break;
            case R.id.b7:
                str = et.getText().toString();
                et.setText(str + "7");
                break;
            case R.id.b8:
                str = et.getText().toString();
                et.setText(str + "8");
                break;
            case R.id.b9:
                str = et.getText().toString();
                et.setText(str + "9");
                break;
            case R.id.b10:
                str = et.getText().toString();
                et.setText(str + "#");
                break;
            case R.id.b11:
                str = et.getText().toString();
                et.setText(str + "0");
                break;
            case R.id.b12:
                str = et.getText().toString();
                if (!str.isEmpty()) {
                    str = str.substring(0, str.length() - 1);
                    et.setText(str);
                }
                break;
            case R.id.b13:
                str = et.getText().toString();
                if(str.length() == 11) {
                    Thread thread = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            int pro = pb.getProgress();
                            int max = pb.getMax();

                            while (pro < max) {

                                Message msg = new Message();
                                msg.what = 0;
                                mHandler.sendMessage(msg);
                                try {
                                    Thread.sleep(100);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }

                            }

                        }
                    });
                    thread.start();

                    if (ContextCompat.checkSelfPermission(this,
                            Manifest.permission.CALL_PHONE)
                            != PackageManager.PERMISSION_GRANTED) {
                        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_CONTACTS}, 1);

                    } else {
                        callPhone();
                    }
                } else {
                    AlertDialog.Builder dialog = new AlertDialog.Builder(this);
                    dialog.setTitle("提示");
                    dialog.setMessage("您的输入有误，请重新输入！");
                    dialog.setCancelable(false);
                    dialog.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            et.setText(null);
                        }
                    });
                    dialog.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    dialog.show();
                }

                break;
            default:
                break;


        }

    }
    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case 1:
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    callPhone();
                } else {
                    Toast.makeText(getApplicationContext(), "授权失败", Toast.LENGTH_SHORT).show();
                }
                break;
            default:
                break;

        }
    }

    public void callPhone() {
        try {
            Intent intent = new Intent(Intent.ACTION_CALL);
            Uri data = Uri.parse("tel:" + et.getText().toString());
            intent.setData(data);
            startActivity(intent);
        }catch(SecurityException e ){
            e.printStackTrace();

        }

    }
}
