package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.myapplication.database.DataStoreManager;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class register extends AppCompatActivity {

    private DataStoreManager dataStoreManager;
    private Gson gson = new Gson();

    private String key = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        initView();
    }

    private void initView() {
        dataStoreManager = new DataStoreManager(this);
        key = getIntent().getStringExtra("KEY_BOARD");

        Button button = findViewById(R.id.reg_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                register();

                finish();
            }
        });
    }

    private void register() {
        String itemsJson = dataStoreManager.getInformation(key);

        List<SingerItem> items = new ArrayList<>();

        if(!itemsJson.isEmpty()) {
            Type listType = new TypeToken<List<SingerItem>>() {}.getType();
            List<SingerItem> savedItems = gson.fromJson(itemsJson, listType);

            if(!savedItems.isEmpty()) {
                items.addAll(savedItems);
            }
        }

        List<SingerItem> newItems = new ArrayList<>();
        String title = ((EditText) findViewById(R.id.title_et)).getText().toString();
        String contents = ((EditText) findViewById(R.id.content_et)).getText().toString();
        newItems.add(new SingerItem(title, contents, -1));
        newItems.addAll(items);

        String newItemsJson = gson.toJson(newItems);
        dataStoreManager.saveInformation(key, newItemsJson);
    }
}