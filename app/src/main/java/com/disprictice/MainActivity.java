package com.disprictice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        initData();
    }

    /**
     * 解决冲突
     */
    private void initData() {
        listView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        
                        break;
                    case MotionEvent.ACTION_UP:
                        break;
                    case MotionEvent.ACTION_HOVER_MOVE:
                        break;
                }
                return false;
            }
        });
    }

    /**
     * 初始化数据
     */
    private void initView() {

        listView = findViewById(R.id.listView);
        final List<String> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add("机器人" + i);
        }
        listView.setAdapter(new BaseAdapter() {
            @Override
            public int getCount() {
                return list.size();
            }

            @Override
            public Object getItem(int position) {
                return null;
            }

            @Override
            public long getItemId(int position) {
                return 0;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                if (convertView == null) {
                    convertView = View
                            .inflate(MainActivity.this, R.layout.item, null);
                }
                TextView tvItem = convertView.findViewById(R.id.tv_item);

                tvItem.setText(list.get(position));

                return convertView;
            }
        });


    }
}
