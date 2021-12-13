package com.example.my1123;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ConstraintLayout layout;
    Button btnSubMove, btnColorMove, btnCamera;
    TextView tvResult;
    ImageView imageView;

    private static final int SUB_CODE = 1000;//MainActivity2
    private static final int COLOR_CODE = 1001;//ColorActivity
    private static final int CAMERA_CODE = 1002;//

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        layout = findViewById(R.id.layout);
        btnSubMove = findViewById(R.id.btnSubMove);
        btnColorMove = findViewById(R.id.btnColorMove);
        tvResult = findViewById(R.id.tvResult);
        btnCamera = findViewById(R.id.btnCamera);
        imageView = findViewById(R.id.imageView);


        btnCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, CAMERA_CODE);

            }
        });

        //이동 후 아이템 클릭 시 로그창에 위치값이 출력되는지 테스트
        btnColorMove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ColorActivity.class);
                startActivityForResult(intent, COLOR_CODE);
            }
        });


        btnSubMove.setOnClickListener(new View.OnClickListener() {
            //resultCode: 이동한 액티비티에서 처리결과를 Result_OK or RESULT_CANCELLED로 확인하는 값
            //DATA:이동한 액티비티에서의 처리된 실제데이터 값

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                //requestCode: 정의된 액티비티의 구분값
                // 규칙은 여러분들이 정의!
                startActivityForResult(intent, SUB_CODE);

            }
        });
    }
    //data:이동한 액티비티에서의 처리된값
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        //널값을허용한다  Nullable
        super.onActivityResult(requestCode, resultCode, data);
        //어떤 액티비티에서 되돌아 왔는지를 체크!
        //성공적으로 처리되었는지 체크!
        if (requestCode == SUB_CODE && resultCode == RESULT_OK) {

            String msg = data.getStringExtra("msg");
            tvResult.setText(msg);

        } else if (requestCode == COLOR_CODE && resultCode == RESULT_OK) {
            String color = data.getStringExtra("color");
            layout.setBackgroundColor(Color.parseColor(color));

        } else if (requestCode == CAMERA_CODE && resultCode == RESULT_OK) {

            Bundle bundle = data.getExtras();
            Bitmap bitmap = (Bitmap) bundle.get("data");
            imageView.setImageBitmap(bitmap);

        }
    }
}


