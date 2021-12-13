package com.example.my1123;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class ColorActivity extends AppCompatActivity {
    ListView colorListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color);
        colorListView = findViewById(R.id.colorListView);

        colorListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //position이 index와 비슷
                Log.d("클릭한 아이템 위치", String.valueOf(position));

                //선택한 색상값을 메인엑티비티에 전달될 수 있도록 구현하시오.
                //MainActivity2 참고!
                String color = "black";

                if (position == 0) {
                    color = "red";
                } else if (position == 1) {
                    color = "green";
                } else {
                    color = "blue";
                }

                Intent intent = new Intent();
                intent.putExtra("color",color);
                setResult(RESULT_OK,intent);
                finish();


            }
        });
    }
}