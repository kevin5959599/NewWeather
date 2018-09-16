package com.example.user.newweather;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.TextView;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by user on 2018/8/30.
 */

public class Parse extends Activity {
    String morning,night;
    String[] am,an,bm,bn,cm,cn;
    String rain_morning,temper_morning,rain_night,temper_night,state_morning,state_night;
    String cityname,countryname,citycode;
    int weathercode;

    private TextView cityT,countryT,temperT_morning,temperT_night,rainT_morning,rainT_night,stateT_morning,stateT_night;


    private Handler mHandler = new Handler()
    {
        public void handleMessage(android.os.Message message)
        {
            switch (message.what)
            {
                case 1:
                    updateTodayWeather((TodayWeather) message.obj);
                    break;
                default:
                    break;
            }
        }
    };
    TodayWeather todayWeather = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.weather_test);
        cityname = getIntent().getStringExtra("cityname");
        countryname = getIntent().getStringExtra("countryname");
        citycode = getIntent().getStringExtra("citycode");
        weathercode = getIntent().getIntExtra("weathercode",weathercode);
        String citycode1 = String.valueOf(citycode);
        Log.d("777777777777",citycode1);
        String weather1 = String.valueOf(weathercode);
        Log.d("999999999999",weather1);
        initView();
        getWeatherDatafromNet();
    }
    private void getWeatherDatafromNet()
    {
        final String address = "http://opendata.cwb.gov.tw/opendataapi?dataid=F-D0047-0"+citycode+"&authorizationkey=CWB-31C940FF-CACC-446B-B684-121414E83C0D";
        Log.d("Address:",address);
        new Thread(new Runnable() {
            @Override
            public void run() {
                HttpURLConnection urlConnection = null;
                try {
                    URL url = new URL(address);
                    urlConnection = (HttpURLConnection) url.openConnection();
                    urlConnection.setRequestMethod("GET");
                    urlConnection.setConnectTimeout(8000);
                    urlConnection.setReadTimeout(8000);
                    InputStream in = urlConnection.getInputStream();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                    StringBuffer sb = new StringBuffer();
                    String str;
                    while((str=reader.readLine())!=null)
                    {
                        sb.append(str);
                        //Log.d("date from url",str);
                    }
                    String response = sb.toString();
                    Log.d("response",response);
                    todayWeather = parseXML(response);
                    if(todayWeather!=null)
                    {
                        Message message = new Message();
                        message.what = 1;
                        message.obj = todayWeather;
                        mHandler.sendMessage(message);
                    }
                }catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        }).start();
    }
    private TodayWeather parseXML(String xmlData)
    {

        TodayWeather todayWeather = null;
        int count = 0;
        int temp_a = 283;
        int temp_b = 289;
        int a = 283;
        int b = 23;
        String string;



        try {
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            XmlPullParser xmlPullParser = factory.newPullParser();
            xmlPullParser.setInput(new StringReader(xmlData));

            int eventType = xmlPullParser.getEventType();


            while (eventType!=xmlPullParser.END_DOCUMENT)
            {
                switch (eventType)
                {
                    //文档开始位置
                    case XmlPullParser.START_DOCUMENT:
                        Log.d("parse", "開始解析");
                        break;
                    //标签元素开始位置
                    case XmlPullParser.START_TAG:
                        if (xmlPullParser.getName().equals("cwbopendata"))
                        {
                            todayWeather = new TodayWeather();
                        }
                        if (todayWeather != null) {

                            if (xmlPullParser.getName().equals("value"))
                            {
                                count = count + 1;

                                /*eventType = xmlPullParser.next();
                                todayWeather.setDetail(xmlPullParser.getText());
                                Log.d("86868686", xmlPullParser.getText());*/
                                /*String count1 = String.valueOf(count);
                                Log.d("0000",count1);*/
                                if(count==temp_a+weathercode*a+weathercode*b){
                                    String weather1 = String.valueOf(weathercode);
                                    Log.d("44444444444444",weather1);

                                    eventType = xmlPullParser.next();
                                    todayWeather.setMorning(xmlPullParser.getText());
                                    Log.d("1111", xmlPullParser.getText());
                                }


                            }


                        }


                        break;
                    case XmlPullParser.END_TAG:
                        break;
                }
                eventType = xmlPullParser.next();
            }
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return todayWeather;
    }
    void initView(){
        cityT = (TextView)findViewById(R.id.city);
        countryT = (TextView)findViewById(R.id.country);
        temperT_morning = (TextView)findViewById(R.id.temper_morning);

        rainT_morning = (TextView)findViewById(R.id.rain_morning);

        stateT_morning = (TextView)findViewById(R.id.state_morning);


        cityT.setText("N/A");
        countryT.setText("N/A");
        temperT_morning.setText("N/A");

        rainT_morning.setText("N/A");

        stateT_morning.setText("N/A");

    }
    void updateTodayWeather(TodayWeather todayWeather)
    {
        morning = todayWeather.toString_Morning();

        Log.d("5555",morning);

        am = morning.split("。");
        bm = am[1].split(" ");
        cm = am[2].split("氏|度");
        rain_morning = bm[1];
        temper_morning = cm[2];
        state_morning = am[0];
        temperT_morning.setText("溫度:"+temper_morning+"℃");
        rainT_morning.setText("降雨:"+rain_morning);
        stateT_morning.setText(state_morning);




        cityT.setText(cityname);
        countryT.setText("("+countryname+")");
        /*for(int i=0;i<c.length;i++){
            System.out.println("array["+i+"] = "+c[i]);
            Log.d("5555555",c[i]);
        }*/
        Log.d("7777",rain_morning);
        Log.d("8888",temper_morning);

    }
}
