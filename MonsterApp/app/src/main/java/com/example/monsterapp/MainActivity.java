package com.example.monsterapp;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;

import java.sql.SQLData;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TextView mMonsterListText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mMonsterListText = findViewById(R.id.monster_list_text);

    }

    @Override
    protected void onResume() {
        super.onResume();

        // TODO 1表示に使うデータを入れるリストを作る
        ArrayList<MonsterDataItem> itemList = new ArrayList<>();

        // TODO 2読み込み専用でインスタンスを作成
        SQLiteDatabase database = new MonsterDataOpenHelper(this).getReadableDatabase();

        // TODO 3
        Cursor cursor = database.query(
                MonsterDataOpenHelper.TABLE_NAME,
                null,
                null,
                null,
                null,
                null,
                null
        );

        // TODO 4
        while (cursor.moveToNext()){
            int id = cursor.getInt(cursor.getColumnIndex(MonsterDataOpenHelper._ID));
            String no = cursor.getString(cursor.getColumnIndex(MonsterDataOpenHelper.COLUMN_NO));
            String name = cursor.getString(cursor.getColumnIndex(MonsterDataOpenHelper.COLUMN_NAME));
            itemList.add(new MonsterDataItem(id, no, name));

        }
        // TODO 5
        cursor.close();
        database.close();

        // TODO 6
        StringBuilder sb = new StringBuilder();
        for(MonsterDataItem item : itemList){
            sb.append(item.toString()).append("\n");
        }

        mMonsterListText.setText(sb);

    }


}
