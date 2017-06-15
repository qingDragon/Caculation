package com.example.yanzhuang.caculation;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.util.*;
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView et;
    Num n;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button b1 = (Button) findViewById(R.id.useless1);
        Button b2 = (Button) findViewById(R.id.useless2);

        Button button1 = (Button) findViewById(R.id.one);
        Button button2 = (Button) findViewById(R.id.two);
        Button button3 = (Button) findViewById(R.id.three);
        Button button4 = (Button) findViewById(R.id.four);
        Button button5 = (Button) findViewById(R.id.five);
        Button button6 = (Button) findViewById(R.id.six);
        Button button7 = (Button) findViewById(R.id.seven);
        Button button8 = (Button) findViewById(R.id.eight);
        Button button9 = (Button) findViewById(R.id.nine);
        Button button0 = (Button) findViewById(R.id.zero);

        Button buttonA = (Button) findViewById(R.id.plus);
        Button buttonB = (Button) findViewById(R.id.minus);
        Button buttonC = (Button) findViewById(R.id.multiply);
        Button buttonD = (Button) findViewById(R.id.devide);
        Button buttonE = (Button) findViewById(R.id.equals);



        Button buttonF = (Button) findViewById(R.id.c);
        Button buttonG = (Button) findViewById(R.id.dot);
        n = new Num();
        et = (TextView) findViewById(R.id.ed);


        buttonG.setOnClickListener(this);
        buttonF.setOnClickListener(this);

        b1.setOnClickListener(this);
        b2.setOnClickListener(this);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);
        button9.setOnClickListener(this);
        button0.setOnClickListener(this);
        buttonA.setOnClickListener(this);
        buttonB.setOnClickListener(this);
        buttonC.setOnClickListener(this);
        buttonD.setOnClickListener(this);
        buttonE.setOnClickListener(this);




    }
    @Override
    public void onClick(View v) {
        String str = null;
        switch(v.getId()){
            case R.id.one:
                if(n.id == 1){
                    et.setText(null);
                }
                str = et.getText().toString();
                et.setText(str+"1");
                n.setNum(0);
                break;
            case R.id.two:
                if(n.id == 1){
                    et.setText(null);
                }
                str = et.getText().toString();
                et.setText(str+"2");
                n.setNum(0);
                break;
            case R.id.three:
                if(n.id == 1){
                    et.setText(null);
                }
                str = et.getText().toString();
                et.setText(str+"3");
                n.setNum(0);
                break;
            case R.id.four:
                if(n.id == 1){
                    et.setText(null);
                }
                str = et.getText().toString();
                et.setText(str+"4");
                n.setNum(0);
                break;
            case R.id.five:
                if(n.id == 1){
                    et.setText(null);
                }
                str = et.getText().toString();
                et.setText(str+"5");
                n.setNum(0);
                break;
            case R.id.six:
                if(n.id == 1){
                    et.setText(null);
                }
                str = et.getText().toString();
                et.setText(str+"6");
                n.setNum(0);
                break;
            case R.id.seven:
                if(n.id == 1){
                    et.setText(null);
                }
                str = et.getText().toString();
                et.setText(str+"7");
                n.setNum(0);
                break;
            case R.id.eight:
                if(n.id == 1){
                    et.setText(null);
                }
                str = et.getText().toString();
                et.setText(str+"8");
                n.setNum(0);
                break;
            case R.id.nine:
                if(n.id == 1){
                    et.setText(null);
                }
                str = et.getText().toString();
                et.setText(str+"9");
                n.setNum(0);
                break;
            case R.id.zero:
                if(n.id == 1){
                    et.setText(null);
                }
                str = et.getText().toString();

                et.setText(str + "0");
                n.setNum(0);
                break;
            case R.id.useless1:
                if(n.id == 1){
                    et.setText(null);
                }
                str = et.getText().toString();
                et.setText(str+"(");
                n.setNum(0);
                break;
            case R.id.useless2:
                if(n.id == 1){
                    et.setText(null);
                }
                str = et.getText().toString();
                et.setText(str+")");
                n.setNum(0);
                break;
            case R.id.plus:
                str = et.getText().toString();
                et.setText(str + "+");
                n.setNum(0);
                break;
            case R.id.minus:
                str = et.getText().toString();
                et.setText(str + "-");
                n.setNum(0);
                break;
            case R.id.multiply:
                str = et.getText().toString();

                et.setText(str + "x");
                n.setNum(0);
                break;
            case R.id.devide:
                str = et.getText().toString();

                et.setText(str + "/");
                n.setNum(0);
                break;
            case R.id.c:
                et.setText(null);
                n.setNum(0);
                break;
            case R.id.dot:
                if (n.id == 1) {
                    et.setText(null);
                }
                str = et.getText().toString();
                if(str.isEmpty()){
                    Toast.makeText(getApplicationContext(),"您的输入有误，请重新输入！",Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    et.setText(str + ".");
                    n.setNum(0);
                }
                break;
            case R.id.equals:
                str = et.getText().toString();
                if(str.isEmpty()){
                    Toast.makeText(getApplicationContext(),"您的输入有误，请重新输入！",Toast.LENGTH_SHORT).show();
                    return;
                }
                if(str.charAt(0)=='+'||str.charAt(0)=='x'||str.charAt(0)=='/'){
                    et.setText(null);
                    Toast.makeText(getApplicationContext(),"您的输入有误，请重新输入！",Toast.LENGTH_SHORT).show();
                    return;
                }
                else{
                    for (int i=1;i<str.length();i++) {
                        char c = str.charAt(i);
                        if(c == '+'||c == '-'||c == 'x'||c == '/'){
                            char d = str.charAt(i-1);
                            char e = str.charAt(i+1);
                            if(d == '+'||d=='-'||d=='x'||d=='/'||e=='+'||e=='-'||e=='x'||e=='/'){

                                Toast.makeText(getApplicationContext(),"您的输入有误，请重新输入！",Toast.LENGTH_SHORT).show();
                                et.setText(null);
                                return;
                            }
                        }
                    }
                    str = removeSign(str);
                    while(str.contains("(")){
                        str = removeBracket(str);

                    }

                    et.setText(new Double(calculate(str)).toString());
                    n.setNum(1);
                }
                break;
            default:
                break;

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mymenu,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.item1:
                Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                startActivity(intent);
                break;
            case R.id.item2:
                Intent intent2 = new Intent(MainActivity.this,Main3Activity.class);
                startActivity(intent2);
                break;
            case R.id.item3:
                Intent intent3 = new Intent(MainActivity.this,Main4Activity.class);
                startActivity(intent3);
                break;
        }
        return true;
    }

    private static double calculate (String exp){
        List<Character> ops = splitOpFromExp(exp);
        List<Double> nums = splitNumFromExp(exp);
        for(int i=0;i<ops.size();i++){
            char op = ops.get(i);
            if(op == 'x'|| op =='/' ){
                ops.remove(i);
                double d1 = nums.remove(i);
                double d2 = nums.remove(i);
                if(op == 'x'){
                    d1 *= d2;
                }
                if(op == '/') {
                    d1 /= d2;
                }
                nums.add(i,d1);
                i--;
            }
        }
        while(!ops.isEmpty()) {
            char c = ops.remove(0);
            double d1 = nums.remove(0);
            double d2 = nums.remove(0);
            if(c == '+'){
                d1 += d2;
            }
            if(c == '-'){
                d1 -= d2;
            }
            nums.add(0,d1);
        }
        return nums.get(0);
    }



    private static List<Character> splitOpFromExp (String exp){

        List<Character> op = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(exp,"0123456789.");
        while(st.hasMoreTokens()){
           char c = st.nextElement().toString().trim().charAt(0);
           op.add(c);
        }
        return op;
    }
    private static List<Double> splitNumFromExp (String exp){

        List<Double> num = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(exp,"+-x/");
        while(st.hasMoreTokens()){
            String str = st.nextElement().toString().trim();
            num.add(Double.parseDouble(str));
        }
        return num;
    }

    private String removeBracket (String exp) {
        int m =0,n=0;
        m = exp.lastIndexOf("(");
        n = exp.indexOf(")",m);
        String substr1 = exp.substring(m+1,n);
        String substr2 = exp.substring(m,n+1);
        if(substr1.isEmpty()){
            Toast.makeText(getApplicationContext(),"您的输入有误，请重新输入！",Toast.LENGTH_SHORT).show();
        }

        String ss = String.valueOf(new Double(calculate(substr1)).intValue());
        return exp.replace(substr2, ss);


    }

    private static String removeSign(String exp){
        for(int i =0;i<exp.length();i++) {
            char c = exp.charAt(i);


            if(c == '-'){
                String s1 = exp.substring(0, i);
                String s2 = exp.substring(i+1,exp.length());

                if( i==0||exp.charAt(i-1)=='('){
                    exp = s1 +"0-"+s2;
                }


            }
        }
        return exp;
    }
}






