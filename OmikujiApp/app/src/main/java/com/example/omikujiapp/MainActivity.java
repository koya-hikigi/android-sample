package com.example.omikujiapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ReceiverCallNotAllowedException;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private int[] omikujiResId = { R.mipmap.ic_daikiti, R.mipmap.ic_chukiti, R.mipmap.ic_shokiti,
            R.mipmap.ic_kyou, R.mipmap.ic_daikyou};

    private ImageView mOmikujiImg;
    private Button mStartBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mOmikujiImg = findViewById(R.id.omikuji_image_view);
        mStartBtn = findViewById(R.id.start_btn);

        mStartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // TODO 配列の数の範囲の乱数を生成
                Random random = new Random();
                int setRandom = random.nextInt(10);


                // TODO 乱数によって表示する画像を判定する

                if(setRandom <= 3 ){
                    mOmikujiImg.setBackgroundResource(omikujiResId[0]);

                } else if(( 4 <= setRandom)&&(setRandom <= 6 )){
                    mOmikujiImg.setBackgroundResource(omikujiResId[1]);

                } else if( 7 == setRandom){
                    mOmikujiImg.setBackgroundResource(omikujiResId[2]);

                } else if( 8 == setRandom){
                    mOmikujiImg.setBackgroundResource(omikujiResId[3]);

                } else if( 9 == setRandom){
                    mOmikujiImg.setBackgroundResource(omikujiResId[4]);

                }


                // TODO 画像を差し替える
 //               mOmikujiImg.setBackgroundResource(omikujiResId[setRandom]);


            }
        });

    }
}
