package com.example.colorcodelist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private int[] colorResIds = {R.color.colorPaleGreen, R.color.colorPaleTurquoise, R.color.colorPaleVioletRed
            , R.color.colorPapayaWhip, R.color.colorPeachPuff, R.color.colorPeru, R.color.colorPink};
    private int[] colorNames = {R.string.pale_green, R.string.pale_turquoise, R.string.pale_violet_red
            , R.string.papaya_whip, R.string.peach_puff, R.string.peru, R.string.pink};

    private ListView mListView;
    private ColorCodeListAdapter mAdapter;
    private List<ColorCodeItem> colorCodeItems = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // ListViewをレイアウトファイルから読み込む。
        mListView = findViewById(R.id.list_view);

        // Adapterを作成する。
        mAdapter = new  ColorCodeListAdapter(this, colorCodeItems);

        // ListAdapterをセットする。
        mListView.setAdapter(mAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        //　表示更新
        displayDataList();

    }
    private void displayDataList(){

        // 表示データ作成
        ArrayList<ColorCodeItem> dataList = new ArrayList<>();
        for(int i = 0 ; i < colorResIds.length; i++){
            dataList.add(new ColorCodeItem(colorResIds[i], colorNames[i]));
        }
        // Adapterのデータをリセットする
        mAdapter.clear();

        // 作成したデータをAdapterに追加する
        mAdapter.addAll(dataList);

        // Adapterにデータが変更されたことを通知する
        mAdapter.notifyDataSetChanged();
    }
}
