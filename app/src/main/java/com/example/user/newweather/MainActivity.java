package com.example.user.newweather;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity implements View.OnClickListener {
    Button test;
    Button parsetest;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       test = (Button)findViewById(R.id.test);
        test.setOnClickListener(this);
        parsetest = (Button)findViewById(R.id.parsetest);
        parsetest.setOnClickListener(this);
    }
    @Override
    public void onClick(View v){
        switch (v.getId())
        {
            case R.id.test:
                // finish();
                Intent intent = new Intent(this,SelectCity.class);
                startActivity(intent);
                break;
            case R.id.parsetest:
                Intent parsetest = new Intent(this,ParseTest.class);
                startActivity(parsetest);
            default:
                break;
        }
    }
}
