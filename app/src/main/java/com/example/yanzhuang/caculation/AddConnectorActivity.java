package com.example.yanzhuang.caculation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddConnectorActivity extends AppCompatActivity implements View.OnClickListener {
    String str1,str2;
    EditText et1,et2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_connector);

        Button b1 = (Button) findViewById(R.id.b1);
        Button b2 = (Button) findViewById(R.id.b2);

        et1 = (EditText) findViewById(R.id.et1);
        et2 = (EditText) findViewById(R.id.et2);

        b1.setOnClickListener(this);


    }
    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.b1:
                str1 = et1.getText().toString();
                str2 = et2.getText().toString();
                String ss= str1 + "#"+str2;
                Log.d("ss",ss);
                Intent intent = new Intent();
                intent.putExtra("data_return",ss);
                setResult(10,intent);
                finish();
                break;
            default:
                break;


        }
    }
}
