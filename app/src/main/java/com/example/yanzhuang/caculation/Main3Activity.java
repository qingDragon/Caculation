package com.example.yanzhuang.caculation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Main3Activity extends AppCompatActivity {
    private String[] data = {"张玄武","周青龙","孙朱雀","顾白虎","张朔","顾阳","孙宏斌","颜壮","QingDragon",
            "玄武","青龙","朱雀","白虎","张朔","顾阳","孙宏斌","颜壮","QingDragon"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,data);
        ListView listView = (ListView)findViewById(R.id.list_item);
        listView.setAdapter(adapter);

    }
}
