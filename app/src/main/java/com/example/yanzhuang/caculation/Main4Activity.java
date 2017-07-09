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

import android.text.style.SuperscriptSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Main4Activity extends AppCompatActivity implements View.OnClickListener {
    private List<Superman> supermanList = new ArrayList<>();
    Superman superman;
    String returnedData=null;
    SupermanAdapter adapter;
    ListView listView;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        Button b1 = (Button) findViewById(R.id.b1);
        Button b2 = (Button)findViewById(R.id.b2);



        b2.setOnClickListener(this);
        b1.setOnClickListener(this);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                superman = supermanList.get(position);

                callPhone();
            }
        });





    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.d("activity",String.valueOf(requestCode));
        switch (requestCode) {
            case 1:
                if(resultCode == 10) {
                    this.returnedData =data.getStringExtra("data_return");
                }
                break;
            default:
        }
    }
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



    @Override
    public void onClick(View v) {
        String[] s = null;
        switch (v.getId()) {
            case R.id.b2:
                Intent intent = new Intent(Main4Activity.this,AddConnectorActivity.class);
                startActivityForResult(intent,1);
                break;
            case R.id.b1:
                if(this.returnedData==null){
                    Log.d("123",returnedData);
                }
                else {
                    s = returnedData.split("#");
                }

                Superman s1 = new Superman(s[0], R.drawable.img_3, s[1]);
                this.supermanList.add(s1);
                Log.d("sm",this.supermanList.get(0).toString());
                adapter = new SupermanAdapter(this,R.layout.superman_item,this.supermanList);


                listView = (ListView) findViewById(R.id.list_view);

                listView.setAdapter(adapter);



                break;





            default:


        }
    }


}







