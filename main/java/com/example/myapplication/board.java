package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class board extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_board);

        ListView listView = findViewById(R.id.listView);
        SingerAdapter adapter = new SingerAdapter();
        adapter.addItem(new SingerItem("자유 게시판", "자유로운 얘기",R.drawable.icon01));
        adapter.addItem(new SingerItem("창작 게시판", "음악 창작 공유",R.drawable.icon2));
        adapter.addItem(new SingerItem("불만 게시판", "여러가지 불만들",R.drawable.icon3));
        adapter.addItem(new SingerItem("발라드 게시판", "발라드 좋아요",R.drawable.icon4));
        adapter.addItem(new SingerItem("힙합 게시판", "힙합 좋아요",R.drawable.icon5));
        adapter.addItem(new SingerItem("팝송 게시판", "팝송 좋아요",R.drawable.icon6));
        adapter.addItem(new SingerItem("R&B 게시판", "R&B 좋아요",R.drawable.icon7));
        adapter.addItem(new SingerItem("게임 게시판", "같이 게임해요",R.drawable.icon8));
        listView.setAdapter(adapter);
    }

    class SingerAdapter extends BaseAdapter {
        //데이터가 들어가있지 않고, 어떻게 담을지만 정의해뒀다.
        ArrayList<SingerItem> items = new ArrayList<SingerItem>();

        @Override
        public int getCount() {
            return items.size();
        }

        public void addItem(SingerItem item){
            items.add(item);
        }

        @Override
        public Object getItem(int position) {
            return items.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        // 어댑터가 데이터를 관리하고 뷰도 만듬
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            SingerItemView singerItemView = null;
            // 코드를 재사용할 수 있도록
            if(convertView == null) {
                singerItemView = new SingerItemView(getApplicationContext());
            } else {
                singerItemView = (SingerItemView)convertView;
            }
            SingerItem item = items.get(position);
            singerItemView.setName(item.getName());
            singerItemView.setMobile(item.getMobile());
            singerItemView.setImage(item.getResId());
            return singerItemView;
        }
    }
}
