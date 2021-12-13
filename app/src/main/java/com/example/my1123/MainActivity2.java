package com.example.my1123;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity2 extends AppCompatActivity {
    Button btnMainMove;
    EditText editMsg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        btnMainMove = findViewById(R.id.btnMainMove);
        editMsg = findViewById(R.id.editMsg);
        btnMainMove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //문제정의: 버튼 클릭 시, 사용자가 입력한 데이터를 MainActivity로 전달되도록 구현하시오.
                //이전 액티비티에서 startActivity()가 아닌 메소드로 호출한 경우에
                //정보를 설정하지 않음!
                Intent intent = new Intent();
                //intent.putExtra("msg","오늘은 날씨가 구름이 많네요..");
                intent.putExtra("msg",editMsg.getText().toString());

                //RESULT_OK:성공
                //RESULT_cancelled:실패
                //setResult(): 이전 액티비티로 성공 or 실패에 대한 값과 결과값을 전달
                setResult(RESULT_OK,intent);
                finish();





            }
        });
    }
}