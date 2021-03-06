package cityname;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.newweather.MainActivity;
import com.example.user.newweather.Parse;
import com.example.user.newweather.R;

/**
 * Created by user on 2018/8/27.
 */

public class Lianjiang extends Activity implements View.OnClickListener {
    private TextView city;
    private ImageView backBtn;
    private ListView cityListLv;
    private String updatecitycode = "-1";
    String citycode = "81";
    int weathercode;
    private String cityname,countryname;
    //選擇城市
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.select_country);
        cityname = getIntent().getStringExtra("cityname");
        backBtn = (ImageView)findViewById(R.id.title_selectCity_back);
        backBtn.setOnClickListener(this);


        final String[] listData = {"南竿鄉","莒光鄉","東引鄉","北竿鄉"};
        cityListLv = (ListView)findViewById(R.id.selectcity_lv);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(Lianjiang.this,android.R.layout.simple_list_item_1,listData);
        cityListLv.setAdapter(adapter);

        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                String text = listData[position];
                //String result = "索引值:" + position + "\n" + "內容" + text;
                String result = "已選擇:"+text;
                Toast.makeText(Lianjiang.this, result,Toast.LENGTH_SHORT).show();

                if(text=="南竿鄉"){
                    updatecitycode = "03";
                    city = (TextView)findViewById(R.id.title_selectCity_name);
                    city.setText("當前城市:南竿鄉");
                    countryname = text;
                    weathercode = 0;
                    Intent intent = new Intent(Lianjiang.this, Parse.class);
                    intent.putExtra("cityname",cityname);
                    intent.putExtra("countryname",countryname);
                    intent.putExtra("citycode",citycode);
                    intent.putExtra("weathercode",weathercode);
                    startActivity(intent);
                }else if(text=="莒光鄉"){
                    updatecitycode = "01";
                    city = (TextView)findViewById(R.id.title_selectCity_name);
                    city.setText("當前城市:莒光鄉");
                    countryname = text;
                    weathercode = 1;
                    Intent intent = new Intent(Lianjiang.this, Parse.class);
                    intent.putExtra("cityname",cityname);
                    intent.putExtra("countryname",countryname);
                    intent.putExtra("citycode",citycode);
                    intent.putExtra("weathercode",weathercode);
                    startActivity(intent);
                }else if(text=="東引鄉"){
                    updatecitycode = "04";
                    city = (TextView)findViewById(R.id.title_selectCity_name);
                    city.setText("當前城市:東引鄉");
                    countryname = text;
                    weathercode = 2;
                    Intent intent = new Intent(Lianjiang.this, Parse.class);
                    intent.putExtra("cityname",cityname);
                    intent.putExtra("countryname",countryname);
                    intent.putExtra("citycode",citycode);
                    intent.putExtra("weathercode",weathercode);
                    startActivity(intent);
                }else if(text=="北竿鄉"){
                    updatecitycode = "05";
                    city = (TextView)findViewById(R.id.title_selectCity_name);
                    city.setText("當前城市:北竿鄉");
                    countryname = text;
                    weathercode = 3;
                    Intent intent = new Intent(Lianjiang.this, Parse.class);
                    intent.putExtra("cityname",cityname);
                    intent.putExtra("countryname",countryname);
                    intent.putExtra("citycode",citycode);
                    intent.putExtra("weathercode",weathercode);
                    startActivity(intent);
                }
            }
        };
        cityListLv.setOnItemClickListener(itemClickListener);
    }
    //把citycode值傳到MainActivity
    @Override
    public void onClick(View v){
        switch (v.getId())
        {
            case R.id.title_selectCity_back:
                // finish();
                Intent intent = new Intent(this,MainActivity.class);
                if(updatecitycode!="-1") {
                    intent.putExtra("citycode", updatecitycode);
                    intent.putExtra("cityname", cityname);
                }
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}
