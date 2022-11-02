package io.mc.mutalk;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigation = findViewById(R.id.bottom_navigation);
        bottomNavigation.setOnItemSelectedListener(item -> {
            switch(item.getItemId()) {
                case R.id.home:
                    Toast.makeText(this, "홈", Toast.LENGTH_SHORT).show();
                    return true;
                case R.id.page2:
                    Toast.makeText(this, "메뉴2", Toast.LENGTH_SHORT).show();
                    return true;
                case R.id.page3:
                    Toast.makeText(this, "메뉴3", Toast.LENGTH_SHORT).show();
                    return true;
                case R.id.page4:
                    Toast.makeText(this, "메뉴4", Toast.LENGTH_SHORT).show();
                    return true;
                case R.id.page5:
                    Toast.makeText(this, "메뉴5", Toast.LENGTH_SHORT).show();
                    return true;
            }
            return false;
        });
    }
}