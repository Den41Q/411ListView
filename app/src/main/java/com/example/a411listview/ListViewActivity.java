package com.example.a411listview;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class ListViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ListView list = findViewById(R.id.list);

        List<Map<String, String>> values = prepareContent();

        SimpleAdapter listContentAdapter = createAdapter(values);

        list.setAdapter(listContentAdapter);
    }

    @NonNull
    private SimpleAdapter createAdapter(List<Map<String, String>> data) {
        return new SimpleAdapter(this, data, R.layout.simple_list_item,
                new String[]{"text_1", "text_2"}, new int[]{R.id.text_1, R.id.text_2});

    }

    @NonNull
    private List<Map<String, String>> prepareContent() {

        List<Map<String, String>> list = new ArrayList<>();

        String[] arrayContent = getString(R.string.large_text).split("\n\n");

        for (String array : arrayContent) {
            Map<String, String> map = new HashMap<>();
            map.put("text_1", array);
            map.put("text_2", Integer.toString(array.length()));
            list.add(map);
        }

        return list;
    }
}