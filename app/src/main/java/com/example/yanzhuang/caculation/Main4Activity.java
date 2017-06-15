package com.example.yanzhuang.caculation;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Main4Activity extends AppCompatActivity {
    private List<Superman> supermanList = new ArrayList<>();
    Superman superman;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        initSupermans();
        SupermanAdapter adapter = new SupermanAdapter(this,R.layout.superman_item,supermanList);
        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                superman = supermanList.get(position);
                /*if(ContextCompat.checkSelfPermission(Main4Activity.this, Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED){
                    ActivityCompat.requestPermissions(Main4Activity.this,new String[] {Manifest.permission.CALL_PHONE},1);
                } else{
                    callPhone();
                }*/
                callPhone();
            }
        });

    }
    /*@Override
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
    }*/
    public void callPhone() {

        try {
            Intent intent = new Intent(Intent.ACTION_CALL);
            Uri data = Uri.parse("tel:" + superman.getNum());
            intent.setData(data);
            startActivity(intent);
        }catch(SecurityException e ){
            e.printStackTrace();

        }

    }
    private void initSupermans() {
        for(int i=0; i<8; i++) {

            Superman s1 = new Superman("我就像这个世界", R.drawable.img_1,"13813322995");
            supermanList.add(s1);

            Superman s2 = new Superman("永远不会被改变", R.drawable.img_1,"18936518056");
            supermanList.add(s2);


        }

    }
}






