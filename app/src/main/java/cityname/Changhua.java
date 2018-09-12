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
import com.example.user.newweather.R;

/**
 * Created by user on 2018/8/27.
 */

public class Changhua extends Activity implements View.OnClickListener {
    private TextView city;
    private ImageView backBtn;
    private ListView cityListLv;
    private String updatecitycode = "-1";
    private String cityname;
    private String test;
    //選擇城市
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.select_country);

        backBtn = (ImageView)findViewById(R.id.title_selectCity_back);
        backBtn.setOnClickListener(this);


        final String[] listData = {"福興鄉","埔鹽鄉","大村鄉","伸港鄉","花壇鄉","埔心鄉","芬園鄉","永靖鄉","線西鄉","埤頭鄉","員林市","溪湖鎮","和美鎮","田中鎮","二水鄉","竹塘鄉","彰化市","芳苑鄉","二林鎮","北斗鎮","溪州鄉","鹿港鎮","秀水鄉","大城鄉","田尾鄉","社頭鄉"};
        cityListLv = (ListView)findViewById(R.id.selectcity_lv);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(Changhua.this,android.R.layout.simple_list_item_1,listData);
        cityListLv.setAdapter(adapter);

        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                String text = listData[position];
                //String result = "索引值:" + position + "\n" + "內容" + text;
                String result = "已選擇:"+text;
                Toast.makeText(Changhua.this, result,Toast.LENGTH_SHORT).show();

                if(text=="福興鄉"){
                    updatecitycode = "03";
                    city = (TextView)findViewById(R.id.title_selectCity_name);
                    city.setText("當前城市:福興鄉");
                    cityname = text;
                }else if(text=="埔鹽鄉"){
                    updatecitycode = "01";
                    city = (TextView)findViewById(R.id.title_selectCity_name);
                    city.setText("當前城市:埔鹽鄉");
                    cityname = text;
                }else if(text=="大村鄉"){
                    updatecitycode = "04";
                    city = (TextView)findViewById(R.id.title_selectCity_name);
                    city.setText("當前城市:大村鄉");
                    cityname = text;
                }else if(text=="伸港鄉"){
                    updatecitycode = "05";
                    city = (TextView)findViewById(R.id.title_selectCity_name);
                    city.setText("當前城市:伸港鄉");
                    cityname = text;
                }else if(text=="花壇鄉"){
                    updatecitycode = "14";
                    city = (TextView)findViewById(R.id.title_selectCity_name);
                    city.setText("當前城市:花壇鄉" +
                            "");
                    cityname = text;
                }else if(text=="埔心鄉"){
                    updatecitycode = "06";
                    city = (TextView)findViewById(R.id.title_selectCity_name);
                    city.setText("當前城市:埔心鄉");
                    cityname = text;
                }else if(text=="芬園鄉"){
                    updatecitycode = "17";
                    city = (TextView)findViewById(R.id.title_selectCity_name);
                    city.setText("當前城市:芬園鄉");
                    cityname = text;
                }else if(text=="永靖鄉"){
                    updatecitycode = "07";
                    city = (TextView)findViewById(R.id.title_selectCity_name);
                    city.setText("當前城市:永靖鄉");
                    cityname = text;
                }else if(text=="線西鄉"){
                    updatecitycode = "08";
                    city = (TextView)findViewById(R.id.title_selectCity_name);
                    city.setText("當前城市:線西鄉");
                    cityname = text;
                }else if(text=="埤頭鄉"){
                    updatecitycode = "09";
                    city = (TextView)findViewById(R.id.title_selectCity_name);
                    city.setText("當前城市:埤頭鄉");
                    cityname = text;
                }else if(text=="員林市"){
                    updatecitycode = "10";
                    city = (TextView)findViewById(R.id.title_selectCity_name);
                    city.setText("當前城市:員林市");
                    cityname = text;
                }else if(text=="溪湖鎮"){
                    updatecitycode = "11";
                    city = (TextView)findViewById(R.id.title_selectCity_name);
                    city.setText("當前城市:溪湖鎮");
                    cityname = text;
                }else if(text=="和美鎮"){
                    updatecitycode = "11";
                    city = (TextView)findViewById(R.id.title_selectCity_name);
                    city.setText("當前城市:和美鎮");
                    cityname = text;
                }else if(text=="田中鎮"){
                    updatecitycode = "11";
                    city = (TextView)findViewById(R.id.title_selectCity_name);
                    city.setText("當前城市:田中鎮");
                    cityname = text;
                }else if(text=="二水鄉"){
                    updatecitycode = "11";
                    city = (TextView)findViewById(R.id.title_selectCity_name);
                    city.setText("當前城市:二水鄉");
                    cityname = text;
                }else if(text=="竹塘鄉"){
                    updatecitycode = "11";
                    city = (TextView)findViewById(R.id.title_selectCity_name);
                    city.setText("當前城市:竹塘鄉");
                    cityname = text;
                }else if(text=="彰化市"){
                    updatecitycode = "11";
                    city = (TextView)findViewById(R.id.title_selectCity_name);
                    city.setText("當前城市:彰化市");
                    cityname = text;
                }else if(text=="芳苑鄉"){
                    updatecitycode = "11";
                    city = (TextView)findViewById(R.id.title_selectCity_name);
                    city.setText("當前城市:芳苑鄉");
                    cityname = text;
                }else if(text=="二林鎮"){
                    updatecitycode = "11";
                    city = (TextView)findViewById(R.id.title_selectCity_name);
                    city.setText("當前城市:二林鎮");
                    cityname = text;
                }else if(text=="北斗鎮"){
                    updatecitycode = "11";
                    city = (TextView)findViewById(R.id.title_selectCity_name);
                    city.setText("當前城市:北斗鎮");
                    cityname = text;
                }else if(text=="溪州鄉"){
                    updatecitycode = "11";
                    city = (TextView)findViewById(R.id.title_selectCity_name);
                    city.setText("當前城市:溪州鄉");
                    cityname = text;
                }else if(text=="鹿港鎮"){
                    updatecitycode = "11";
                    city = (TextView)findViewById(R.id.title_selectCity_name);
                    city.setText("當前城市:鹿港鎮");
                    cityname = text;
                }else if(text=="秀水鄉"){
                    updatecitycode = "11";
                    city = (TextView)findViewById(R.id.title_selectCity_name);
                    city.setText("當前城市:秀水鄉");
                    cityname = text;
                }else if(text=="大城鄉"){
                    updatecitycode = "11";
                    city = (TextView)findViewById(R.id.title_selectCity_name);
                    city.setText("當前城市:大城鄉");
                    cityname = text;
                }else if(text=="田尾鄉"){
                    updatecitycode = "11";
                    city = (TextView)findViewById(R.id.title_selectCity_name);
                    city.setText("當前城市:田尾鄉");
                    cityname = text;
                }else if(text=="社頭鄉"){
                    updatecitycode = "11";
                    city = (TextView)findViewById(R.id.title_selectCity_name);
                    city.setText("當前城市:社頭鄉");
                    cityname = text;
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
